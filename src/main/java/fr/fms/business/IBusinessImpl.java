package fr.fms.business;

import fr.fms.dao.CustomerRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Customer;
import fr.fms.entities.OrderItem;
import fr.fms.web.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * All business implementation
 *
 * @author Alejandra
 */
@Service
public class IBusinessImpl implements IBusiness {


    private static final Logger logger = LoggerFactory.getLogger(IBusinessImpl.class);
    private final CustomerRepository customerRepository;
    private final UserController userController;
    private final Map<Long, OrderItem> cart = new HashMap<>();

    @Autowired
    public IBusinessImpl(CustomerRepository customerRepository, UserController userController) {
        this.customerRepository = customerRepository;
        this.userController = userController;
    }

    @Override
    public void addOneArticleToCart(Article article) {
        if (article != null) {
            if (isArticleInCart(article.getId())) {
                OrderItem orderItem = cart.get(article.getId());
                int newQuantity = orderItem.getQuantity() + 1;
                orderItem.setQuantity(newQuantity);
                orderItem.setTotalPrice(calculateTotalPrice(newQuantity, article));
                cart.put(article.getId(), orderItem);
            } else {
                OrderItem newOrderItem = new OrderItem();
                newOrderItem.setQuantity(1);
                newOrderItem.setTotalPrice(article.getPrice());
                newOrderItem.setArticle(article);
                cart.put(article.getId(), newOrderItem);
            }
        } else {
            logger.error("Voila l'erreur");
        }
    }

    @Override
    public void removeOneArticleFromCart(Long id) {
        OrderItem orderItem = cart.get(id);
        if (orderItem.getQuantity() > 1) {
            int newQuantity = orderItem.getQuantity() - 1;
            orderItem.setQuantity(newQuantity);
            orderItem.setTotalPrice(calculateTotalPrice(newQuantity, orderItem.getArticle()));
            cart.put(id, orderItem);
        } else {
            cart.remove(id);
        }
    }

    @Override
    public double calculateTotalPrice(int quantity, Article article) {

        return quantity * article.getPrice();
    }

    @Override
    public boolean isArticleInCart(Long articleId) {
        for (Map.Entry<Long, OrderItem> entry : cart.entrySet()) {
            if (Objects.equals(articleId, entry.getKey())) {
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
}


