package fr.fms.web;

import fr.fms.business.IBusinessImpl;
import fr.fms.dao.CustomerRepository;
import fr.fms.dao.OrderItemRepository;
import fr.fms.dao.OrderRepository;
import fr.fms.dao.UserRepository;
import fr.fms.entities.Customer;
import fr.fms.entities.Order;
import fr.fms.entities.OrderItem;
import fr.fms.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    IBusinessImpl business;

    @Autowired
    UserController userController;

    @GetMapping("/customer")
    private String customer(Model model){
        model.addAttribute("customer", new Customer());
        return "customer";
    }

    @PostMapping("/saveCustomer")
    private String saveCustomer(@Valid Customer customer, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "customer";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = userController.currentUserName(authentication);
        User currentUser = userRepository.findByUsername(currentUserName);
        customerRepository.save(new Customer(null, customer.getName(), customer.getLastName(), customer.getAddress(), customer.getEmail(), customer.getPhone(), null, currentUser));
        return "redirect:/order";
    }

    @GetMapping("/order")
    private String order(Model model){
        model.addAttribute("listOrderItem", business.getCartContent());
        model.addAttribute("customer", business.getCustomer());
        model.addAttribute("totalAmount", business.getTotalAmountOrder());
        return "order";
    }

    @GetMapping("/saveOrder")
    public String saveOrder(Model model){
        List<OrderItem> orderItems = business.getCartContent();
        Customer customer = business.getCustomer();
        double totalAmount = business.getTotalAmountOrder();
        Order order = orderRepository.save(new Order(null, LocalDate.now(), totalAmount, customer, orderItems));
        orderItems.forEach(orderItem -> {
            orderItem.setOrder(order);
            orderItemRepository.save(new OrderItem(null, orderItem.getQuantity(), orderItem.getTotalPrice(), orderItem.getArticle(), orderItem.getOrder()));
        });
        business.clearCart();
        return "redirect:/index";
    }
}
