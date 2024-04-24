package fr.fms;

import fr.fms.business.IBusinessImpl;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;
<<<<<<< HEAD
=======
import fr.fms.entities.OrderItem;
>>>>>>> test_mockito
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

<<<<<<< HEAD
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
=======
import static org.junit.jupiter.api.Assertions.*;
>>>>>>> test_mockito

@SpringBootTest
class SpringStockMvcSecApplicationTests {

	@Autowired
	IBusinessImpl business;

<<<<<<< HEAD
=======

>>>>>>> test_mockito
	@Test
	void contextLoads() {
		assertFalse(1==2);
	}
	@Test
	void testGetTotalAmountOrder(){
		business.addOneArticleToCart(new Article((long)1,"Samsung s8 2024",250, null,null));
		business.addOneArticleToCart(new Article((long)2,"Samsung s9 2024",350, null,null));

		assertEquals(business.getTotalAmountOrder(),600);

<<<<<<< HEAD
=======
	}
	@Test
	void testAddOneArticleToCart() {
		Article articleToAdd = new Article((long)3, "Samsung s20 2024", 600, null,null);
		business.addOneArticleToCart(articleToAdd);
		OrderItem orderItem = new OrderItem();
		orderItem.setQuantity(1);
		orderItem.setTotalPrice(600);
		orderItem.setArticle(articleToAdd);
		assertTrue(business.getCartContent().contains(orderItem));
>>>>>>> test_mockito
	}

//	@Test
//	void testremoveOneArticleFromCart(){
//
//	}

}
