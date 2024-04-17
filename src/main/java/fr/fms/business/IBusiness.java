package fr.fms.business;

import fr.fms.entities.Article;

import java.util.List;

public interface IBusiness {

    //Méthode pour ajouter un article au panier
    public void addOneArticleToCart(Article article);

    //Méthode pour supprimer l'article du panier
    public void removeOneArticleFromCart(Article article);

    //Méthode pour modifier la quantité d'articles
    public void UpdateQuantityForCart();

    //Méthode pour calculer le total
    public double calculateTotalPrice();

    //Méthode pour récuperer les articles du panier
    public List<Article> getCartContent();

}
