package fr.fms.business;

import fr.fms.entities.Article;

public interface IBusiness {
    //Méthode pour ajouter un article au panier
    //Méthode pour supprimer l'article du panier
    //Méthode pour modifier la quantité d'articles
    //Méthode pour calculer le total

    public void addOneArticleToCart(Article article);
    public void removeOneArticleFromCart(Article article);
    public void UpdateQuantityForCart();


}
