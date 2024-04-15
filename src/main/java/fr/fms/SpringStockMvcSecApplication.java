package fr.fms;
import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;
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
    @Autowired
    CategoryRepository categoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringStockMvcSecApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        /*Category pc = categoryRepository.save(new Category(null ,"PC", "tous les ordinateurs et accessoires",null));
        Category smartphone = categoryRepository.save(new Category(null ,"smartphone", "tous les smartphones et accessoires",null));
        Category tablet = categoryRepository.save(new Category(null ,"tablet", "tous les tablet et accessoires",null));
        Category composant = categoryRepository.save(new Category(null ,"composant", "tous les composants et accessoires",null));
        Category audio = categoryRepository.save(new Category(null ,"audio", "tous les audios et accessoires",null));
        Category  jeuxVideo = categoryRepository.save(new Category(null ," jeux video", "tous les  jeux video",null));





        articleRepository.save(new Article(null, "Samsung S8", 250, smartphone, null));
        articleRepository.save(new Article(null, "Samsung  S9", 300, smartphone, null));
        articleRepository.save(new Article(null, "Iphone 10", 500, smartphone, null));
        articleRepository.save(new Article(null, "Samsung S10", 250,smartphone, null));
        articleRepository.save(new Article(null, "Samsung  S9", 300, smartphone, null));
        articleRepository.save(new Article(null, "Iphone 10", 500, smartphone, null));
        articleRepository.save(new Article(null, "Galaxy A15", 250, smartphone, null));
        articleRepository.save(new Article(null, "Xiaomi 14", 300, smartphone, null));
        articleRepository.save(new Article(null, "Motorola E13", 80, smartphone, null));
        articleRepository.save(new Article(null, "Xiaomi 13C", 250, smartphone, null));
        articleRepository.save(new Article(null, "Galaxy S21", 300, smartphone, null));
        articleRepository.save(new Article(null, "Xiaomi 12C", 130, smartphone, null));
        articleRepository.save(new Article(null, "Lenovo M700", 500, pc, null));
        articleRepository.save(new Article(null, "Asus E510", 600, pc, null));
        articleRepository.save(new Article(null, "Asus Rog", 700, pc, null));
        articleRepository.save(new Article(null, "GalaxyTable", 300, tablet, null));
        articleRepository.save(new Article(null, "GalaxyTable3", 500, tablet, null));
        articleRepository.save(new Article(null, "GalaxyTable6", 600, tablet, null));
        articleRepository.save(new Article(null, "RAM-AMDEFGH", 200, composant, null));
        articleRepository.save(new Article(null, "RAM-AMDEFGHIJK", 300, composant, null));
        articleRepository.save(new Article(null, "RR-paude10", 300, audio, null));
        articleRepository.save(new Article(null, "RR-paude11", 400, audio, null));
        articleRepository.save(new Article(null, "RR-paude12", 500, audio, null));
        articleRepository.save(new Article(null, "colofduttyhardcore", 200, jeuxVideo, null));
        articleRepository.save(new Article(null, "lessimseux", 200, jeuxVideo, null));
        articleRepository.save(new Article(null, "thelastofyours", 200, jeuxVideo, null));*/

        // Utilisation du logger pour afficher les articles
        articleRepository.findAll().forEach(a -> logger.info(a.toString()));
    }
}
