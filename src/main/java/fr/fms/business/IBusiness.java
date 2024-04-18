package fr.fms.business;

import fr.fms.entities.Article;
import fr.fms.entities.OrderItem;

import java.util.List;

public interface IBusiness {

    //Méthode pour ajouter un article au panier
    public void addOneArticleToCart(Article article);

    //Méthode pour supprimer l'article du panier
    public void removeOneArticleFromCart(Article article);

    //Méthode pour calculer le total
    double calculateTotalPrice(int quantity, Article article);

    //Méthode pour récuperer les articles du panier
    public List<Article> getCartContent();

    boolean isArticleInCart(Long articleId);

    OrderItem getOrderItem(Article article);
}
