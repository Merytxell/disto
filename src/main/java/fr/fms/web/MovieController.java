package fr.fms.web;

import javax.validation.Valid;

import fr.fms.entities.Cinema;
import fr.fms.entities.Movie;
import javafx.embed.swing.SwingNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import fr.fms.business.IBusinessImpl;
//import fr.fms.entities.Category;
import fr.fms.exceptions.ManageErrors;

@Controller
public class MovieController {
    @Autowired
    IBusinessImpl businessImpl;

    private final Logger logger = LoggerFactory.getLogger(MovieController.class);

    @GetMapping("/index")
    public String index(Model model, @RequestParam(name="page" , defaultValue = "0") int page,
                        @RequestParam(name="keyword" , defaultValue = "") String kw,
                        @RequestParam(name="idCity" , defaultValue = "0") Long idCity,
                        @RequestParam(name="nbcart" , defaultValue = "0") int cart,
                        @ModelAttribute(name="error") String error) {

        Page<Cinema> cinemas = null;
        Page<Movie>movies=null;
        model.addAttribute("error", model.getAttribute("error"));
        try {
            if (idCity > 0) {
                cinemas = businessImpl.getCinemaByCityPage(idCity, page);
                if (cinemas.isEmpty())
                    model.addAttribute("error", ManageErrors.STR_ERROR);
            } else cinemas = businessImpl.getCinemasPages(kw, page);

            model.addAttribute("idCity", idCity);
            model.addAttribute("listCinema", cinemas.getContent());
            model.addAttribute("listMovies", movies.getContent());
            model.addAttribute("pages", new int[cinemas.getTotalPages()]);
            model.addAttribute("currentPage", page);
            model.addAttribute("keyword", kw);
            model.addAttribute("city", businessImpl.getCity());
            model.addAttribute("nbcart", businessImpl.getNbCart());

            String username;
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
                username = ((UserDetails)principal).getUsername();
            } else {
                username = principal.toString();
                if(username.contains("anonymous"))
                    username = "";
            }
            model.addAttribute("username", " " +username);
        }
        catch(Exception e) {
            model.addAttribute("error",e.getMessage());
            logger.error("[MOVIE CONTROLLER : INDEX] : {} " , e.getMessage());
        }
        return "movies";
    }

            @GetMapping("/delete")
            public String delete (Long id,int page, String keyword, Long idCity, RedirectAttributes redirectAttrs){
                //ToDo avant de supprimer un article, il faut supprimer les commandes qui y font références OrderItem/Order sans quoi Exception
                try {
                    businessImpl.deleteMovie(id);
                } catch (Exception e) {
                    redirectAttrs.addAttribute("error", e.getMessage());
                    logger.error("[MOVIE CONTROLLER : DELETE] : {} ", e.getMessage());
                }
                return "redirect:/index?page=" + page + "&keyword=" + keyword + "&idCity=" + idCity;
            }

            @GetMapping("/edit")
            public String edit (Long id, Model model){
                Movie movie;
                try {
                   movie= businessImpl.getMovieById(id);
                    model.addAttribute("cinema", businessImpl.getCinema());
                    model.addAttribute("cinema", businessImpl.getCity());
                    model.addAttribute("movie", movie);
                } catch (Exception e) {
                    model.addAttribute("error", e.getMessage());
                    logger.error("[MOVIE CONTROLLER : EDIT] : {} ", e.getMessage());
                }
                return "edit";
            }

            @GetMapping("/movie")
            public String movie (Model model){
                model.addAttribute("movie", new Movie());
                try {
                    model.addAttribute("cinema", businessImpl.getCinema());
                    model.addAttribute("city", businessImpl.getCity());
                } catch (Exception e) {
                    model.addAttribute("error", e.getMessage());
                    logger.error("[MOVIE CONTROLLER : MANAGE NEW MOVIE] : {} ", e.getMessage());
                }
                return "movies";
            }

            @PostMapping("/save")
            public String save (@Valid Movie movie, BindingResult bindingResult, Model model, RedirectAttributes
            redirectAttrs){
                try {
                    if (bindingResult.hasErrors()) {
                        model.addAttribute("categories", businessImpl.getCinema());
                        model.addAttribute("categories", businessImpl.getCity());
                        return "movies";
                    }
                    businessImpl.saveMovie(movie);
                } catch (Exception e) {
                    redirectAttrs.addAttribute("error", e.getMessage());
                    logger.error("[MOVIE CONTROLLER : SAVE MOVIE] : {} ", e.getMessage());
                }
                return "redirect:/index";
            }

            @RequestMapping("/greating")
            public @ResponseBody String greating () {
                return businessImpl.great();
            }
        }

