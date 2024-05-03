package fr.fms.web;

import javax.validation.Valid;

import fr.fms.dao.CinemaRepository;
import fr.fms.dao.CityRepository;
import fr.fms.dao.MovieRepository;
import fr.fms.entities.Cinema;
import fr.fms.entities.City;
import fr.fms.entities.Movie;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import fr.fms.business.IBusinessImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class MovieController {
    private static final String CITY_LIST = "cityList" ;
    private static final String CINEMA_LIST = "cinemaList";
    private static final String MOVIE_LIST = "MovieList" ;
    private static final String PAGES = "pages";
    private static final String CURRENT_PAGE = "currentPage";
    private static final String KEYWORD = "keyword";

    private final IBusinessImpl business;
    @Autowired
    IBusinessImpl businessImpl;
    @Autowired
    CityRepository cityRepository;
    @Autowired
    CinemaRepository cinemaRepository;
    @Autowired
    MovieRepository movieRepository;


  private final Logger logger = LoggerFactory.getLogger(MovieController.class);

    public MovieController(IBusinessImpl business) {
        this.business = business;
    }

    @GetMapping("/index")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
                        @RequestParam(name = "keyword", defaultValue = "") String kw,
                        @RequestParam(name = "city", defaultValue = "") String city,
                        @RequestParam(name = "cinema", defaultValue = "") String cinema) throws Exception {

        model.addAttribute("cartSize", business.getCartSize());
        if (!kw.isEmpty()) {
            Page<Cinema> cinemasByKeyword = cinemaRepository.findByCinemaNameContains(kw, PageRequest.of(page, 5));
            model.addAttribute(CINEMA_LIST, cinemasByKeyword);
            model.addAttribute(KEYWORD, kw);
            model.addAttribute(CITY_LIST, cityRepository.findAll());



        } else if (!city.isEmpty()) {
            List<City> cinemaByCity = cityRepository.findByCityName(city);
            model.addAttribute(CINEMA_LIST, cinemaByCity);
            model.addAttribute(CITY_LIST, cityRepository.findAll());


        }
        List<Movie> movies = businessImpl.getMovies();
        model.addAttribute("movies", movies);
        List<City> cities = businessImpl.getCity();
        model.addAttribute("cities", cities);
        List<Cinema> cinemas= businessImpl.getCinema();
        model.addAttribute("cinemas", cinemas);
        return "index";
    }

//
//    @GetMapping("/index")
//    public String index(Model model,
//                        @RequestParam(name = "page", defaultValue = "0") int page,
//                        @RequestParam(name = "keyword", defaultValue = "") String kw,
//                        @RequestParam(name = "cityId", required = false) Long cityId) {
//
//        try {
//            List<Cinema> cinemas = new ArrayList<>();
//            City city = null;
//
//            if (cityId != null) {
//                city = businessImpl.getCityById(cityId);
//                cinemas = businessImpl.getCinemasByCity(city);
//
//
//                if (!kw.isEmpty()) {
//                    Page<Cinema> cinemasByKeyword = businessImpl.getCinemasByKeyword(kw, page);
//                    cinemas.retainAll(cinemasByKeyword.getContent());
//                }
//            } else {
//
//                cinemas = businessImpl.getCinemasByKeyword(kw, page).getContent();
//            }
//            List<Movie> movies = businessImpl.getMovies();
//            model.addAttribute("listCinema", cinemas);
//            model.addAttribute("movies", movies);
//
//
//            List<City> cities = businessImpl.getCity();
//            model.addAttribute("cities", cities);
//
//        } catch (Exception e) {
//            model.addAttribute("error", e.getMessage());
//            logger.error("[INDEX CONTROLLER] : {}", e.getMessage());
//        }
//        return "index";
//    }

    @GetMapping("/admin")
    public String admin(Model model) {

        return "admin";
    }


    @GetMapping("/deleteCity")
    public String deleteCity(@RequestParam Long id, RedirectAttributes redirectAttrs) {
        try {
            businessImpl.deleteCity(id);
        } catch (Exception e) {
            redirectAttrs.addAttribute("error", e.getMessage());
            logger.error("[MOVIE CONTROLLER : DELETE CITY] : {}", e.getMessage());
        }
        return "redirect:/index";
    }



    @GetMapping("/editCity")
    public String editCity(@RequestParam Long id, Model model) {
        Optional<City> cityToUpdate = cityRepository.findById(id);
        City city= cityToUpdate.orElse(null);
        List<City> cityList = cityRepository.findAll();
        model.addAttribute(CITY_LIST, cityList);
        model.addAttribute("city", city);
        return "editCity";
    }

    @PostMapping("/saveCity")
    public String saveCity(@Valid City city, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
        try {
            if (bindingResult.hasErrors()) {
                return "index";
            }
            businessImpl.saveCity(city);
        } catch (Exception e) {
            redirectAttrs.addAttribute("error", e.getMessage());
            logger.error("[MOVIE CONTROLLER : SAVE CITY] : {}", e.getMessage());
        }
        return "redirect/index";
    }

    @GetMapping("/deleteCinema")
    public String deleteCinema(@RequestParam Long id, RedirectAttributes redirectAttrs) {
        try {
            businessImpl.deleteCinema(id);
        } catch (Exception e) {
            redirectAttrs.addAttribute("error", e.getMessage());
            logger.error("[MOVIE CONTROLLER : DELETE CINEMA] : {}", e.getMessage());
        }
        return "redirect:/index";
    }

    @GetMapping("/editCinema")
    public String editCinema(@RequestParam Long id, Model model) {
        Optional<Cinema> cinemaToUpdate = cinemaRepository.findById(id);
        Cinema cinema = cinemaToUpdate.orElse(null);
        List<Cinema> cinemaList = cinemaRepository.findAll();
        model.addAttribute(CINEMA_LIST, cinemaList);
        model.addAttribute("cinema", cinema);
        return "editCinema";
    }

    @PostMapping("/saveCinema")
    public String saveCinema(@Valid Cinema cinema, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
        try {
            if (bindingResult.hasErrors()) {
                return "index";
            }
            businessImpl.saveCinema(cinema);
        } catch (Exception e) {
            redirectAttrs.addAttribute("error", e.getMessage());
            logger.error("[MOVIE CONTROLLER : SAVE CINEMA] : {}", e.getMessage());
        }
        return "redirect/index";
    }

    @GetMapping("/deleteMovie")
    public String deleteMovie(@RequestParam Long id, RedirectAttributes redirectAttrs) {
        try {
            businessImpl.deleteMovie(id);
        } catch (Exception e) {
            redirectAttrs.addAttribute("error", e.getMessage());
            logger.error("[MOVIE CONTROLLER : DELETE MOVIE] : {}", e.getMessage());
        }
        return "redirect:/index";
    }

    @GetMapping("/editMovie")
    public String editMovie(@RequestParam Long id, Model model) {

        Optional<Movie> movieToUpdate = movieRepository.findById(id);
        Movie movie = movieToUpdate.orElse(null);
        List<Movie> movieList = movieRepository.findAll();
        model.addAttribute(MOVIE_LIST, movieList);
        model.addAttribute("movie", movie);
        return "editCinema";
    }

    @PostMapping("/saveMovie")
    public String saveMovie(@Valid Movie movie, BindingResult bindingResult, RedirectAttributes redirectAttrs, Model model) {
        try {
            if (bindingResult.hasErrors()) {
                model.addAttribute("movie", movie);
                return "index";
            }
            businessImpl.saveMovie(movie);
        } catch (Exception e) {
            redirectAttrs.addAttribute("error", e.getMessage());
            logger.error("[MOVIE CONTROLLER : SAVE MOVIE] : {}", e.getMessage());
        }
        return "redirect/index";

    }

    @RequestMapping("/greating")
    public @ResponseBody String greating() {
        return businessImpl.great();
    }
}


