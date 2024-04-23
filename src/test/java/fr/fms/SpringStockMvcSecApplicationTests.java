package fr.fms;

import fr.fms.business.IBusinessImpl;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;
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
	void testGetTotalAmountOrder(){
		business.addOneArticleToCart(new Article((long)1,"Samsung s8 2024",250, null,null));
		business.addOneArticleToCart(new Article((long)2,"Samsung s9 2024",350, null,null));

		assertEquals(business.getTotalAmountOrder(),600);

	}

}
