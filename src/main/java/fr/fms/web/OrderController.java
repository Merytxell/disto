package fr.fms.web;

import fr.fms.dao.CustomerRepository;
import fr.fms.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class OrderController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/customer")
    private String customer(Model model){
        model.addAttribute("customer", new Customer());
        return "customer";
    }

    @PostMapping("/saveCustomer")
    private String saveCustomer(@Valid Customer customer, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "customer";

        customerRepository.save(customer);
        return "redirect:/index";
    }

    @GetMapping("/order")
    private String order(){
        return "order";
    }
}
