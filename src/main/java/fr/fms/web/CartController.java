//package fr.fms.web;
//
//import fr.fms.business.IBusinessImpl;
//import fr.fms.dao.ArticleRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.util.Optional;
//
///**
// * Cart controller
// *
// * @author Alejandra
// */
//@Controller
//public class CartController {
//
//
//    private static final String LIST_ORDER_ITEMS = "listOrderItems";
//    private final ArticleRepository articleRepository;
//    private final IBusinessImpl business;
//
//    @Autowired
//    public CartController(ArticleRepository articleRepository, IBusinessImpl business) {
//        this.articleRepository = articleRepository;
//        this.business = business;
//    }
//
//    /**
//     * cart mapping
//     *
//     * @param model spring model
//     */
//    @GetMapping("/cart")
//    public String cart(Model model) {
//        model.addAttribute(LIST_ORDER_ITEMS, business.getCartContent());
//        return "cart";
//    }
//
//    /**
//     * add to cart mapping
//     *
//     * @param id    article id
//     * @param model spring model
//     */
//    @GetMapping("/addCart")
//    public String addCart(Long id, Model model) {
//        Optional<Article> articleOptional = articleRepository.findById(id);
//        if (articleOptional.isPresent()) {
//            Article article = articleOptional.get();
//            business.addOneArticleToCart(article);
//            model.addAttribute(LIST_ORDER_ITEMS, business.getCartContent());
//            return "redirect:/index";
//        } else {
//            return "403";
//        }
//    }
//
//    /**
//     * delete order item mapping
//     *
//     * @param id    article id
//     * @param model spring model
//     */
//    @GetMapping("/deleteOrderItem")
//    public String deleteOrderItem(Long id, Model model) {
//        business.removeOneArticleFromCart(id);
//        model.addAttribute(LIST_ORDER_ITEMS, business.getCartContent());
//        return "cart";
//    }
//}
//
