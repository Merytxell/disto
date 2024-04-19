package fr.fms.business;

import fr.fms.entities.Article;
import fr.fms.entities.OrderItem;

import java.util.List;

public interface IBusiness {

    //Méthode pour ajouter un article au panier
    public void addOneArticleToCart(Article article);

    //Méthode pour supprimer l'article du panier
    public void removeOneArticleFromCart(Long id);

    //Méthode pour calculer le total
    double calculateTotalPrice(int quantity, Article article);

    OrderItem getOrderItem(Long id);

    List<OrderItem> getOrderItemContent();
}
