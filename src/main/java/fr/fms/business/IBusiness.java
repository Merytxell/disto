package fr.fms.business;

import fr.fms.entities.Article;
import fr.fms.entities.Customer;
import fr.fms.entities.OrderItem;

import java.util.List;

public interface IBusiness {

    /**
     * Add one article to cart
     *
     * @param article article to add
     * @author Alejandra
     */
    void addOneArticleToCart(Article article);

    /**
     * Delete one article from cart
     *
     * @param id article id to delete
     * @author Alejandra
     */
    void removeOneArticleFromCart(Long id);

    /**
     * Calculate items total price
     *
     * @param quantity article quantity
     * @param article  article in cart
     * @author Alejandra
     */
    double calculateTotalPrice(int quantity, Article article);

    /**
     * Verify if the article is into the cart
     *
     * @param articleId article id to verify
     * @return boolean
     */
    boolean isArticleInCart(Long articleId);

    /**
     * Get all item content
     *
     * @author Alejandra
     */
    List<OrderItem> getCartContent();

    /**
     * Retrieve the last customer by username of logged user
     *
     * @author Frederic
     */
    Customer getCustomer();

    /**
     * Calculate order total amount
     *
     * @author Frederic
     */
    double getTotalAmountOrder();

    int getCartSize();

    /**
     * Clear the cart
     *
     * @author Frederic
     */
    void clearCart();
}
