package fr.fms;
import fr.fms.dao.ArticleRepository;
import fr.fms.entities.Article;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringStockMvcSecApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(SpringStockMvcSecApplication.class);


    private final ArticleRepository articleRepository;
    @Autowired
    public SpringStockMvcSecApplication(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringStockMvcSecApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        articleRepository.save(new Article(null, "Samddddddddddddddddddsung S8", 250));
        articleRepository.save(new Article(null, "Samdddddddddddddddsung S9", 300));
        articleRepository.save(new Article(null, "Iphdddddddddddddddone 10", 500));
        articleRepository.save(new Article(null, "Sadddddddddddddddddddmsung S8", 250));
        articleRepository.save(new Article(null, "Samddddddddddddddddddsung S9", 300));
        articleRepository.save(new Article(null, "Ipdddddddddddddddhone 10", 500));
        articleRepository.save(new Article(null, "Samdddddddddddsung S8", 250));
        articleRepository.save(new Article(null, "Samsdddddddddddddung S9", 300));
        articleRepository.save(new Article(null, "Iphdddddddddddddddone 10", 500));
        articleRepository.save(new Article(null, "Samddddddddddddddddddsung S8", 250));
        articleRepository.save(new Article(null, "Samsddddddddddddddddung S9", 300));
        articleRepository.save(new Article(null, "Iphdddddddddddddddddone 10", 500));

        // Utilisation du logger pour afficher les articles
        articleRepository.findAll().forEach(a -> logger.info(a.toString()));
    }
}
