package fr.fms.web;

import fr.fms.business.IBusinessImpl;
import fr.fms.dao.CustomerRepository;
import fr.fms.dao.OrderItemRepository;
import fr.fms.dao.OrderRepository;
import fr.fms.dao.UserRepository;
import fr.fms.entities.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

/**
 * order controller
 *
 * @author Frederic
 */
@Controller
public class OrderController {

    private static final String CUSTOMER = "customer";
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final UserRepository userRepository;
    private final IBusinessImpl business;
    private final UserController userController;

    public OrderController(CustomerRepository customerRepository, OrderRepository orderRepository,
                           OrderItemRepository orderItemRepository, UserRepository userRepository,
                           IBusinessImpl business, UserController userController) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.userRepository = userRepository;
        this.business = business;
        this.userController = userController;
    }

    @GetMapping("/customer")
    String customer(Model model) {
        model.addAttribute(CUSTOMER, new CustomerDTO());
        return CUSTOMER;
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/saveCustomer")
    String saveCustomer(@Valid Customer customer, BindingResult bindingResult){
        if(customer.getName() == null || customer.getLastName() == null || customer.getAddress() == null || customer.getEmail() == null || customer.getPhone() == null) return "404";
        if(bindingResult.hasErrors()) return CUSTOMER;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = userController.currentUserName(authentication);
        User currentUser = userRepository.findByUsername(currentUserName);
        customerRepository.save(new Customer(null, customer.getName(), customer.getLastName(), customer.getAddress(), customer.getEmail(), customer.getPhone(), null, currentUser));
        return "redirect:/order";
    }

    @GetMapping("/order")
    String order(Model model) {
        model.addAttribute("listOrderItem", business.getCartContent());
        model.addAttribute(CUSTOMER, business.getCustomer());
        model.addAttribute("totalAmount", business.getTotalAmountOrder());
        return "order";
    }


    @GetMapping("/saveOrder")
    public String saveOrder() {
        List<OrderItem> orderItems = business.getCartContent();
        Customer customer = business.getCustomer();
        double totalAmount = business.getTotalAmountOrder();
        if (customer == null || orderItems.isEmpty()) return "redirect:/404";
        Order order = orderRepository.save(new Order(null, LocalDate.now(), totalAmount, customer, orderItems));
        orderItems.forEach(orderItem -> {
            orderItem.setOrder(order);
            orderItemRepository.save(new OrderItem(null, orderItem.getQuantity(), orderItem.getTotalPrice(), orderItem.getMovie(), orderItem.getOrder()));
        });
        business.clearCart();
        return "redirect:/index";
    }
}
