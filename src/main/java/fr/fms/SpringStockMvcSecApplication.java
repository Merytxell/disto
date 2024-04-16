package fr.fms;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;
import fr.fms.dao.RoleRepository;
import fr.fms.dao.UserRepository;
import fr.fms.entities.Role;
import fr.fms.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringStockMvcSecApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(SpringStockMvcSecApplication.class);


    private final ArticleRepository articleRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    public SpringStockMvcSecApplication(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;

    }

    public static void main(String[] args) {
        SpringApplication.run(SpringStockMvcSecApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Category pc = categoryRepository.save(new Category(null, "PC", "tous les ordinateurs et accessoires", null));
        Category smartphone = categoryRepository.save(new Category(null, "smartphone", "tous les smartphones et accessoires", null));
        Category tablet = categoryRepository.save(new Category(null, "tablet", "tous les tablet et accessoires", null));
        Category composant = categoryRepository.save(new Category(null, "composant", "tous les composants et accessoires", null));
        Category audio = categoryRepository.save(new Category(null, "audio", "tous les audios et accessoires", null));
        Category jeuxVideo = categoryRepository.save(new Category(null, " jeux video", "tous les  jeux video", null));

        articleRepository.save(new Article(null, "Samsung S8 2024", 250, smartphone));
        articleRepository.save(new Article(null, "HP Pavilion Laptop", 700, pc));
        articleRepository.save(new Article(null, "iPad Pro 12.9", 1000, tablet));
        articleRepository.save(new Article(null, "AMD Ryzen 7 5800X", 450, composant));
        articleRepository.save(new Article(null, "Bose QuietComfort 35 II", 300, audio));
        articleRepository.save(new Article(null, "FIFA 25 2024", 160, jeuxVideo));
        articleRepository.save(new Article(null, "iPhone 13 Pro", 1100, smartphone));
        articleRepository.save(new Article(null, "Dell XPS 15", 1500, pc));
        articleRepository.save(new Article(null, "Samsung Galaxy Tab S7", 800, tablet));
        articleRepository.save(new Article(null, "NVIDIA GeForce RTX 3080", 700, composant));
        articleRepository.save(new Article(null, "Sony WH-1000XM4", 350, audio));
        articleRepository.save(new Article(null, "Call of Duty: Modern Warfare", 150, jeuxVideo));
        articleRepository.save(new Article(null, "Google Pixel 6", 900, smartphone));
        articleRepository.save(new Article(null, "Asus ROG Zephyrus G14", 1200, pc));
        articleRepository.save(new Article(null, "Amazon Fire HD 10", 200, tablet));
        articleRepository.save(new Article(null, "Corsair Vengeance RGB Pro 16GB", 120, composant));
        articleRepository.save(new Article(null, "JBL Flip 5 2024", 100, audio));
        articleRepository.save(new Article(null, "The Last of Us Part II", 140, jeuxVideo));
        articleRepository.save(new Article(null, "OnePlus 9 Pro", 800, smartphone));
        articleRepository.save(new Article(null, "Microsoft Surface Laptop 4", 1300, pc));
        articleRepository.save(new Article(null, "Lenovo Tab M10 Plus", 250, tablet));
        articleRepository.save(new Article(null, "Western Digital Blue 1TB SSD", 150, composant));
        articleRepository.save(new Article(null, "Apple AirPods Pro", 250, audio));
        articleRepository.save(new Article(null, "Assassin's Creed Valhalla", 155, jeuxVideo));
        articleRepository.save(new Article(null, "Xiaomi Mi 11 2024", 700, smartphone));
        articleRepository.save(new Article(null, "Acer Predator Helios 300", 1000, pc));
        articleRepository.save(new Article(null, "Samsung Galaxy Tab A7", 300, tablet));
        articleRepository.save(new Article(null, "Crucial Ballistix 32GB DDR4 RAM", 200, composant));
        articleRepository.save(new Article(null, "Sennheiser HD 650", 400, audio));
        articleRepository.save(new Article(null, "Minecraft 2024", 120, jeuxVideo));
        articleRepository.save(new Article(null, "Google Pixel 5a", 600, smartphone));
        articleRepository.save(new Article(null, "Razer Blade 15", 1800, pc));
        articleRepository.save(new Article(null, "Amazon Fire 7", 150, tablet));
        articleRepository.save(new Article(null, "Seagate BarraCuda 2TB HDD", 180, composant));
        articleRepository.save(new Article(null, "Bose SoundLink Mini II", 200, audio));
        articleRepository.save(new Article(null, "Grand Theft Auto V", 130, jeuxVideo));
        articleRepository.save(new Article(null, "Huawei P40 Pro", 850, smartphone));
        articleRepository.save(new Article(null, "Alienware m15 R4", 2200, pc));
        articleRepository.save(new Article(null, "Lenovo Tab P11", 350, tablet));
        articleRepository.save(new Article(null, "EVGA GeForce GTX 1660 Super", 300, composant));
        articleRepository.save(new Article(null, "Jabra Elite 85t", 300, audio));
        articleRepository.save(new Article(null, "Red Dead Redemption 2", 140, jeuxVideo));
        articleRepository.save(new Article(null, "OnePlus 8T 2024", 700, smartphone));
        articleRepository.save(new Article(null, "MSI GS66 Stealth", 2000, pc));
        articleRepository.save(new Article(null, "Samsung Galaxy Tab S6 Lite", 400, tablet));
        articleRepository.save(new Article(null, "AMD Radeon RX 6700 XT", 600, composant));
        articleRepository.save(new Article(null, "Sony WF-1000XM4 2024", 280, audio));
        articleRepository.save(new Article(null, "Overwatch 2024", 140, jeuxVideo));
        articleRepository.save(new Article(null, "Xiaomi Mi 11 Ultra", 1200, smartphone));
        articleRepository.save(new Article(null, "Razer Blade Stealth 13", 1500, pc));
        articleRepository.save(new Article(null, "Apple iPad Air", 600, tablet));
        articleRepository.save(new Article(null, "NZXT Kraken X73", 150, composant));
        articleRepository.save(new Article(null, "Anker Soundcore Liberty Air 2 Pro", 130, audio));
        articleRepository.save(new Article(null, "Fortnite 2024", 100, jeuxVideo));
        articleRepository.save(new Article(null, "Google Pixel 6 Pro", 1000, smartphone));
        articleRepository.save(new Article(null, "MSI GE76 Raider", 2500, pc));
        articleRepository.save(new Article(null, "Samsung Galaxy Tab S7+", 900, tablet));
        articleRepository.save(new Article(null, "Gigabyte GeForce RTX 3060", 400, composant));
        articleRepository.save(new Article(null, "SteelSeries Arctis 7", 150, audio));
        articleRepository.save(new Article(null, "League of Legends", 100, jeuxVideo));

<<<<<<< HEAD
        
=======



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

        generateData();
>>>>>>> branche_de_claire
    }

    public void generateData() {
        Role guest = roleRepository.save(new Role(null, "visiteurs", null));
        Role user = roleRepository.save(new Role(null, "users", null));
        Role admin = roleRepository.save(new Role(null, "admins", null));

        List<Role> fredRoles = new ArrayList<>();
        fredRoles.add(admin);
        fredRoles.add(user);
        User fred = userRepository.save(new User(null, "fred2024", "FmsAcad@2024$", fredRoles));
    }
}
