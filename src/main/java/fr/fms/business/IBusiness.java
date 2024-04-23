package fr.fms.business;

import fr.fms.entities.Article;
import fr.fms.entities.Customer;
import fr.fms.entities.OrderItem;

import java.util.List;

public interface IBusiness {

    /** Add one article to cart
     * @author Alejandra
     * @param article article to add
     * */
    public void addOneArticleToCart(Article article);

    /** Delete one article from cart
     * @author Alejandra
     * @param id article id to delete
     * */
    public void removeOneArticleFromCart(Long id);

    /** Calculate items total price
     * @author Alejandra
     * @param quantity article quantity
     * @param article article in cart
     * */
    double calculateTotalPrice(int quantity, Article article);

    /**
     * Verify if the article is into the cart
     * @param articleId article id to verify
     * @return boolean
     */
    boolean isArticleInCart(Long articleId);

    /** Get all item content
     * @author Alejandra
     * */
    List<OrderItem> getCartContent();

    /**
     * Retrieve the last customer by username of logged user
     * @author Frederic
     */
    Customer getCustomer();

    /**
     * Calculate order total amount
     * @author Frederic
     */
    double getTotalAmountOrder();

    /**
     * Clear the cart
     * @author Frederic
     */
    void clearCart();
}
