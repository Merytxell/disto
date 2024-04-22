package fr.fms.business;

import fr.fms.entities.Article;
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

    /** Get order item
     * @author Alejandra
     * @param id order item id
     * */
    OrderItem getOrderItem(Long id);

    /** Get all item content
     * @author Alejandra
     * */
    List<OrderItem> getOrderItemContent();
}
