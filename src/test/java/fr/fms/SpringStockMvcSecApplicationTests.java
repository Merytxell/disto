package fr.fms;

import fr.fms.business.IBusinessImpl;
import fr.fms.entities.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class SpringStockMvcSecApplicationTests {
	@Autowired
	IBusinessImpl business;

	@Test
	void contextLoads() {
		assertFalse(1==2);
	}

	@Test
	void testTotalAmontCart() {
		business.addOneArticleToCart(new Article(null, "Samsung S8 2024", 250, null));
		business.addOneArticleToCart(new Article((long)2, "HP Pavilion Laptop",250, 1, null));
		business.addOneArticleToCart(new Article((long)2, "Samsung S8 2024", 500, 1, null));
		business.addOneArticleToCart(new Article((long)2, "Samsung",250, 1, null));


		assertEquals(business.calculateTotalPrice(int quantity, article) ;
	}
}
