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

        Category pc = categoryRepository.save(new Category(null ,"PC", "tous les ordinateurs et accessoires",null));
        Category smartphone = categoryRepository.save(new Category(null ,"smartphone", "tous les smartphones et accessoires",null));
        Category tablet = categoryRepository.save(new Category(null ,"tablet", "tous les tablet et accessoires",null));
        Category composant = categoryRepository.save(new Category(null ,"composant", "tous les composants et accessoires",null));
        Category audio = categoryRepository.save(new Category(null ,"audio", "tous les audios et accessoires",null));
        Category  jeuxVideo = categoryRepository.save(new Category(null ," jeux video", "tous les  jeux video",null));





        articleRepository.save(new Article(null, "Samddddddddddddddddddsung S8", 250, smartphone));
        articleRepository.save(new Article(null, "Samdddddddddddddddsung S9", 300, smartphone));
        articleRepository.save(new Article(null, "Iphdddddddddddddddone 10", 500, smartphone));
        articleRepository.save(new Article(null, "Sadddddddddddddddddddmsung S8", 250,smartphone));
        articleRepository.save(new Article(null, "Samddddddddddddddddddsung S9", 300, smartphone));
        articleRepository.save(new Article(null, "Ipdddddddddddddddhone 10", 500, smartphone));
        articleRepository.save(new Article(null, "Samdddddddddddsung S8", 250, smartphone));
        articleRepository.save(new Article(null, "Samsdddddddddddddung S9", 300, smartphone));
        articleRepository.save(new Article(null, "Iphdddddddddddddddone 10", 500, smartphone));
        articleRepository.save(new Article(null, "Samddddddddddddddddddsung S8", 250, smartphone));
        articleRepository.save(new Article(null, "Samsddddddddddddddddung S9", 300, smartphone));
        articleRepository.save(new Article(null, "Iphdddddddddddddddddone 10", 500, smartphone));
        articleRepository.save(new Article(null, "Azuzussss1", 500, pc));
        articleRepository.save(new Article(null, "Azuzussss4", 600, pc));
        articleRepository.save(new Article(null, "Azuzussss8", 700, pc));
        articleRepository.save(new Article(null, "GalaxyTable", 300, tablet));
        articleRepository.save(new Article(null, "GalaxyTable3", 500, tablet));
        articleRepository.save(new Article(null, "GalaxyTable6", 600, tablet));
        articleRepository.save(new Article(null, "RAM-AMDEFGH", 200, composant));
        articleRepository.save(new Article(null, "RAM-AMDEFGHIJK", 300, composant));
        articleRepository.save(new Article(null, "RR-paude10", 300, audio));
        articleRepository.save(new Article(null, "RR-paude11", 400, audio));
        articleRepository.save(new Article(null, "RR-paude12", 500, audio));
        articleRepository.save(new Article(null, "colofduttyhardcore", 200, jeuxVideo));
        articleRepository.save(new Article(null, "lessimseux", 200, jeuxVideo));
        articleRepository.save(new Article(null, "thelastofyours", 200, jeuxVideo));

        // Utilisation du logger pour afficher les articles
        articleRepository.findAll().forEach(a -> logger.info(a.toString()));
    }
}
