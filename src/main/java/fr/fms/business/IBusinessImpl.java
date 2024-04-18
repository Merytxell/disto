package fr.fms.business;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CustomerRepository;
import fr.fms.dao.OrderItemRepository;
import fr.fms.entities.Article;
import fr.fms.entities.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IBusinessImpl implements IBusiness {

  @Autowired
  ArticleRepository articleRepository;
  @Autowired
  CustomerRepository customerRepository;

  @Autowired
  OrderItemRepository orderItemRepository;

  Collection<Article> cart = new ArrayList<>();

  @Override
  public void addOneArticleToCart(Article article) {
   if (article != null) {
     boolean articleAlreadyInCart = isArticleInCart(article.getId());
     if (articleAlreadyInCart){
        Optional<OrderItem> item =  orderItemRepository.findByArticleId(article.getId());

        if (item.isPresent()){
          OrderItem it=item.get();
          int newQuantity = it.getQuantity() +1;
          it.setQuantity(newQuantity);
          it.setTotalPrice(calculateTotalPrice(newQuantity, article));
          orderItemRepository.save(it);
        }
     } else {

       cart.add(article);
       OrderItem item = new OrderItem();
       item.setQuantity(1);
       item.setTotalPrice(article.getPrice());
       item.setArticle(article);
       orderItemRepository.save(item);
     }
   } else {
    System.out.println("Voila l'erreur");
    }
  }

  @Override
  public void removeOneArticleFromCart(Article article) {
    cart.remove(article);
  }

  @Override
  public double calculateTotalPrice(int quantity, Article article) {
    double totalPrice = quantity*article.getPrice();

    return totalPrice;
  }

  @Override
  public List<Article> getCartContent(){
    return (List<Article>) cart;
  }

  @Override
  public boolean isArticleInCart(Long articleId){
    for ( Article article: cart ) {
      if (Objects.equals(articleId, article.getId())) {
        return true;
      }
    }
    return false;
  }

  @Override
  public OrderItem getOrderItem(Article article) {
    Optional<OrderItem> item = orderItemRepository.findByArticleId(article.getId());
    if (item.isPresent()) {
      OrderItem orderItem = item.get();
      return orderItem;
    }
      return null;
  }
}


