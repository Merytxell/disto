package fr.fms.business;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CustomerRepository;
import fr.fms.entities.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class IBusinessImpl implements IBusiness {

  @Autowired
  ArticleRepository articleRepository;
  @Autowired
  CustomerRepository customerRepository;

  Collection<Article> cart = new ArrayList<>();

  @Override
  public void addOneArticleToCart(Article article) {
   if (article != null) {
     cart.add(article);
   } else {
    System.out.println("Voila l'erreur");
    }
  }

  @Override
  public void removeOneArticleFromCart(Article article) {
    cart.remove(article);
  }

  @Override
  public void UpdateQuantityForCart() {

  }

  @Override
  public double calculateTotalPrice() {
    double totalPrice = 0;
    for (Article article : cart) {
      totalPrice += article.getPrice();
    }
    return totalPrice;
  }

  @Override
  public List<Article> getCartContent(){
    return (List<Article>) cart;
  }
}


