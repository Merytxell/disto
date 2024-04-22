package fr.fms.business;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CustomerRepository;
import fr.fms.dao.OrderItemRepository;
import fr.fms.entities.Article;
import fr.fms.entities.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/** All business implementation
 * @author Alejandra
 * */
@Service
public class IBusinessImpl implements IBusiness {

  @Autowired
  ArticleRepository articleRepository;
  @Autowired
  CustomerRepository customerRepository;

  @Autowired
  OrderItemRepository orderItemRepository;

  @Override
  public void addOneArticleToCart(Article article) {
   if (article != null) {
        Optional<OrderItem> item =  orderItemRepository.findByArticleId(article.getId());
        if (item.isPresent()){
          OrderItem it=item.get();
          int newQuantity = it.getQuantity() +1;
          it.setQuantity(newQuantity);
          it.setTotalPrice(calculateTotalPrice(newQuantity, article));
          orderItemRepository.save(it);
        } else {
          OrderItem newOrderitem = new OrderItem();
          newOrderitem.setQuantity(1);
          newOrderitem.setTotalPrice(article.getPrice());
          newOrderitem.setArticle(article);
          orderItemRepository.save(newOrderitem);
        }
   } else {
    System.out.println("Voila l'erreur");
    }
  }

  @Override
  public void removeOneArticleFromCart(Long id) {
    OrderItem orderItem = getOrderItem(id);
    if(orderItem.getQuantity() > 1) {
      int newQuantity = orderItem.getQuantity() -1;
      orderItem.setQuantity(newQuantity);
      orderItem.setTotalPrice(calculateTotalPrice(newQuantity, orderItem.getArticle()));
      orderItemRepository.save(orderItem);
    } else {
      orderItemRepository.deleteById(id);
    }
  }

  @Override
  public double calculateTotalPrice(int quantity, Article article) {
    double totalPrice = quantity*article.getPrice();

    return totalPrice;
  }

  @Override
  public OrderItem getOrderItem(Long id) {
    Optional<OrderItem> item = orderItemRepository.findById(id);
    if (item.isPresent()) {
      OrderItem orderItem = item.get();
      return orderItem;
    }
      return null;
  }

  @Override
  public List<OrderItem> getOrderItemContent(){
    List<OrderItem> orderItemList = orderItemRepository.findAll();
    return orderItemList;
  }
}


