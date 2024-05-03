package fr.fms.web;

import fr.fms.business.IBusinessImpl;
import fr.fms.dao.MovieRepository;
import fr.fms.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;


@Controller
public class CartController {


    private static final String LIST_ORDER_ITEMS = "listOrderItems";
    private final MovieRepository movieRepository;
    private final IBusinessImpl business;

    @Autowired
    public CartController( MovieRepository movieRepository, IBusinessImpl business) {
        this.movieRepository = movieRepository;
        this.business = business;
    }

    @GetMapping("/cart")
    public String cart(Model model) {
        model.addAttribute(LIST_ORDER_ITEMS, business.getCartContent());
        return "cart";
    }

    @GetMapping("/addCart")
    public String addCart(Long id, Model model) {
        Optional<Movie> movieOptional =movieRepository.findById(id);
        if (movieOptional.isPresent()) {
           Movie movie = movieOptional.get();
            business.addOneMovieToCart(movie);
            model.addAttribute(LIST_ORDER_ITEMS, business.getCartContent());
            return "redirect:/index";
        } else {
            return "403";
        }
    }

    @GetMapping("/deleteOrderItem")
    public String deleteOrderItem(Long id, Model model) {
        business.removeOneMovieFromCart(id);
        model.addAttribute(LIST_ORDER_ITEMS, business.getCartContent());
        return "cart";
    }
}

