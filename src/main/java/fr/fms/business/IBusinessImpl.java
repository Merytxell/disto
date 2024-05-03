package fr.fms.business;

import fr.fms.dao.*;
import fr.fms.entities.*;
import fr.fms.web.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class IBusinessImpl implements IBusiness {


    private static final Logger logger = LoggerFactory.getLogger(IBusinessImpl.class);
    private static final int PAGE_SIZE = 5 ;
    private final CustomerRepository customerRepository;

    private final Map<Long, OrderItem> cart = new HashMap<>();
    private final CinemaRepository cinemaRepository;
    private final UserController userController;
    private final CityRepository cityRepository;
    private final MovieRepository movieRepository;
    public Object getCinemasByCity;

    @Autowired
    public IBusinessImpl(CustomerRepository customerRepository, UserController userController, CinemaRepository cinemaRepository, CityRepository cityRepository, MovieRepository movieRepository) {
        this.customerRepository = customerRepository;
        this.userController = userController;
        this.cinemaRepository=cinemaRepository;
        this.cityRepository=cityRepository;
        this.movieRepository=movieRepository;
    }

    @Override
    public void addOneMovieToCart(Movie movie) {
        if (movie!= null) {
            if (isMovieInCart(movie.getId())) {
                OrderItem orderItem = cart.get(movie.getId());
                int newQuantity = orderItem.getQuantity() + 1;
                orderItem.setQuantity(newQuantity);
                orderItem.setTotalPrice(calculateTotalPrice(newQuantity, movie));
                cart.put(movie.getId(), orderItem);
            } else {
                OrderItem newOrderItem = new OrderItem();
                newOrderItem.setQuantity(1);
                newOrderItem.setTotalPrice(movie.getPrice());
                newOrderItem.setMovie(movie);
                cart.put(movie.getId(), newOrderItem);
            }
        } else {
            logger.error("Voila l'erreur");
        }
    }



    @Override
    public void removeOneMovieFromCart(Long id) {
        OrderItem orderItem = cart.get(id);
        if (orderItem.getQuantity() > 1) {
            int newQuantity = orderItem.getQuantity() - 1;
            orderItem.setQuantity(newQuantity);
            orderItem.setTotalPrice(calculateTotalPrice(newQuantity, orderItem.getMovie()));
            cart.put(id, orderItem);
        } else {
            cart.remove(id);
        }
    }

    @Override
    public double calculateTotalPrice(int quantity, Movie movie) {

        return quantity * movie.getPrice();
    }

    @Override
    public boolean isMovieInCart(Long movieId) {
        for (Map.Entry<Long, OrderItem> entry : cart.entrySet()) {
            if (Objects.equals(movieId, entry.getKey())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<OrderItem> getCartContent() {
        return new ArrayList<>(cart.values());
    }


    @Override
    public Customer getCustomer() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = userController.currentUserName(authentication);
        List<Customer> customers = customerRepository.findByUserUsernameOrderByIdDesc(currentUserName);
        if (!customers.isEmpty()) return customers.get(0);
        else return new Customer();
    }

    @Override
    public double getTotalAmountOrder() {

        return cart
                .values()
                .stream()
                .mapToDouble(OrderItem::getTotalPrice)
                .sum();

    }

    @Override
    public int getCartSize() {
        return cart.values().stream().mapToInt(OrderItem::getQuantity).sum();
    }

    @Override
    public void clearCart() {
        cart.clear();
    }

    public Page<Cinema> getCinemaByCityPage(Long idCity, int page) {
        return cinemaRepository.findByCityId(idCity, PageRequest.of(page, 5));

    }


    public List <City> getCity() throws Exception{
        return cityRepository.findAll();
    }

    public int getNbCart() {
        return cart.size();
    }

    public void deleteMovie(Long id) throws Exception {
        movieRepository.deleteById(id);
    }

    public Movie getMovieById(Long id) throws Exception {
        Optional<Movie> optional = movieRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;

    }

    public List <Cinema> getCinema() throws Exception {
        return cinemaRepository.findAll();
    }

    public void saveMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public String great() {
        return "Hello World";
    }

    public Page<Cinema> getfindByCinemaNameContains(String kw, Pageable pageable) {
        return cinemaRepository.findByCinemaNameContains(kw, pageable);
    }

    public Page<Cinema> getCinemasByCity(String city, int page) {
        return cinemaRepository.findByCityCityNameIgnoreCase(city, PageRequest.of(page, PAGE_SIZE));
    }

    public Page<Cinema> getAllCinemas(int page) {
        Pageable pageable = PageRequest.of(page, PAGE_SIZE);
        List<Cinema> allCinemas = cinemaRepository.findAll();
        return new PageImpl<>(allCinemas, pageable, allCinemas.size());
    }

    public List<Movie> getMoviesByCinemas(List<Cinema> cinemas) {
        List<Movie> movies = new ArrayList<>();
        for (Cinema cinema : cinemas){
                    List <Movie>moviesInCinema= (List<Movie>) cinema.getMovie();

        }
        return movies;
    }


        public List<Movie> getMovies () {
            return movieRepository.findAll();
        }

    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }

//    public Page<Cinema> getCinemasByCinemaName(String cinemaName, int page) {
//        return cinemaRepository.findByCinemaNameContainingIgnoreCase(cinemaName, PageRequest.of(page, PAGE_SIZE));
//        }

    public City getCityById(Long cityId) {
        Optional<City> optional = cityRepository.findById(cityId);
        return optional.isPresent() ? optional.get() : null;
    }

    public List<Cinema>getCinemasByCity(City city) {
        return cinemaRepository.findByCity(city);
    }

    public void deleteCinema(Long id) {
        cinemaRepository.deleteById(id);

    }

    public void saveCity(City city) {
        cityRepository.save(city);
    }

    public Cinema getCinemaById(Long id) {
        Optional<Cinema> optional = cinemaRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    public void saveCinema(Cinema cinema) {
        cinemaRepository.save(cinema);
    }
}









