package fr.fms;
import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.web.ArticleController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Collections;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest

@AutoConfigureMockMvc
public class ArticleControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArticleRepository articleRepository;


    @MockBean
    private CategoryRepository categoryRepository;

    @Test
    void testIndex() throws Exception {
        Page<Article> emptyPage = new PageImpl<>(Collections.emptyList());
        when(articleRepository.findAll(any(PageRequest.class))).thenReturn(emptyPage);

    mockMvc.perform(get("/index"))
            .andExpect(status().isOk())
            .andExpect(view().name("articles"));

    }

}
