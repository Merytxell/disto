package fr.fms.business;

import fr.fms.entities.Customer;
import fr.fms.entities.Movie;
import fr.fms.entities.OrderItem;

import java.util.List;

public interface IBusiness {




    void addOneMovieToCart(Movie movie);

    void removeOneMovieFromCart(Long id);


    double calculateTotalPrice(int quantity, Movie movie);


    boolean isMovieInCart(Long movieId);


    List<OrderItem> getCartContent();

    Customer getCustomer();


    double getTotalAmountOrder();

    int getCartSize();


    void clearCart();
}
