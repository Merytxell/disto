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
		business.addOneArticleToCart(new Article(1L, "Samsung S8 2024", 200, null, null));
		business.addOneArticleToCart(new Article(2L, "Test", 200, null, null));
		business.addOneArticleToCart(new Article(3L, "Test 2", 100, null, null));
		business.addOneArticleToCart(new Article(4L, "Test 3", 1000, null, null));


		assertEquals(1500, business.getTotalAmountOrder()) ;
	}
}
