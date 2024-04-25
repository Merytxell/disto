package fr.fms.business;

import fr.fms.dao.CustomerRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Customer;
import fr.fms.entities.OrderItem;
import fr.fms.web.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

/** All business implementation
 * @author Alejandra
 * */
@Service
public class IBusinessImpl implements IBusiness {

  @Autowired
  CustomerRepository customerRepository;

  @Autowired
  UserController userController;

  Map<Long, OrderItem> cart = new HashMap<>();

  @Override
  public void addOneArticleToCart(Article article) {
   if (article != null) {
     if (isArticleInCart(article.getId())) {
       OrderItem orderItem = cart.get(article.getId());
       int newQuantity = orderItem.getQuantity() +1;
       orderItem.setQuantity(newQuantity);
       orderItem.setTotalPrice(calculateTotalPrice(newQuantity, article));
       cart.put(article.getId(), orderItem);
     } else {
       OrderItem newOrderItem = new OrderItem();
       newOrderItem.setQuantity(1);
       newOrderItem.setTotalPrice(article.getPrice());
       newOrderItem.setArticle(article);
       cart.put(article.getId(), newOrderItem);
     }
   } else {
    System.out.println("Voila l'erreur");
    }
  }

  @Override
  public void removeOneArticleFromCart(Long id) {
    OrderItem orderItem = cart.get(id);
    if(orderItem.getQuantity() > 1){
      int newQuantity = orderItem.getQuantity() -1;
      orderItem.setQuantity(newQuantity);
      orderItem.setTotalPrice(calculateTotalPrice(newQuantity, orderItem.getArticle()));
      cart.put(id, orderItem);
    }else{
      cart.remove(id);
    }
  }

  @Override
  public double calculateTotalPrice(int quantity, Article article) {
    double totalPrice = quantity*article.getPrice();

    return totalPrice;
  }

  @Override
  public boolean isArticleInCart(Long articleId){
    for (Map.Entry<Long, OrderItem> entry : cart.entrySet()) {
      if (Objects.equals(articleId, entry.getKey())) {
        return true;
      }
    }
    return false;
  }

  @Override
  public List<OrderItem> getCartContent(){
    return new ArrayList<>(cart.values());
  }


  @Override
  public Customer getCustomer(){
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String currentUserName = userController.currentUserName(authentication);
    List<Customer> customers = customerRepository.findByUserUsernameOrderByIdDesc(currentUserName);
    if(!customers.isEmpty()) return customers.get(0);
    else return new Customer();
  }

  @Override
  public double getTotalAmountOrder(){
    return cart.values().stream().mapToDouble(OrderItem::getTotalPrice).sum();
  }

  @Override
  public int getCartSize(){
    return cart.values().stream().mapToInt(OrderItem::getQuantity).sum();
  }

  @Override
  public void clearCart(){
    cart.clear();
  }
}


