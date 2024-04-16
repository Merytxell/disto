package fr.fms;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringStockMvcSecApplication implements CommandLineRunner {

    private final ArticleRepository articleRepository;
    @Autowired
    CategoryRepository categoryRepository;

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

        articleRepository.save(new Article(null, "iPhone 12 Pro 2024", 900, smartphone));
        articleRepository.save(new Article(null, "Dell XPS 13  2024", 1200, pc));
        articleRepository.save(new Article(null, "Samsung Galaxy Tab S7 ", 700, tablet));
        articleRepository.save(new Article(null, "Corsair Vengeance RGB Pro 16GB", 150, composant));
        articleRepository.save(new Article(null, "Bose QuietComfort Earbuds", 250, audio));
        articleRepository.save(new Article(null, "Assassin's Creed Valhalla", 510, jeuxVideo));
        articleRepository.save(new Article(null, "Google Pixel 5av 2024", 600, smartphone));
        articleRepository.save(new Article(null, "HP Omen 15  2024", 1500, pc));
        articleRepository.save(new Article(null, "Apple iPad Air 2024", 600, tablet));
        articleRepository.save(new Article(null, "Western Digital Blue 1TB SSD", 120, composant));
        articleRepository.save(new Article(null, "Sony WH-1000XM4", 350, audio));
        articleRepository.save(new Article(null, "Cyberpunk 2077", 400, jeuxVideo));
        articleRepository.save(new Article(null, "OnePlus 9 Pro", 800, smartphone));
        articleRepository.save(new Article(null, "Microsoft Surface Book 3", 2000, pc));
        articleRepository.save(new Article(null, "Amazon Fire HD 10", 200, tablet));
        articleRepository.save(new Article(null, "NVIDIA GeForce RTX 3060", 400, composant));
        articleRepository.save(new Article(null, "Sennheiser HD 660S", 400, audio));
        articleRepository.save(new Article(null, "The Witcher 3: Wild Hunt", 300, jeuxVideo));
        articleRepository.save(new Article(null, "Samsung Galaxy S21 Ultra", 1200, smartphone));
        articleRepository.save(new Article(null, "Asus ROG Strix Scar 15", 2200, pc));
        articleRepository.save(new Article(null, "Apple iPad Pro 12.9", 1000, tablet));
        articleRepository.save(new Article(null, "AMD Ryzen 9 5900X", 550, composant));
        articleRepository.save(new Article(null, "JBL Charge 4", 150, audio));
        articleRepository.save(new Article(null, "FIFA 17 2002", 600, jeuxVideo));
        articleRepository.save(new Article(null, "Google Pixel 6", 900, smartphone));
        articleRepository.save(new Article(null, "Alienware Area-51m", 3000, pc));
        articleRepository.save(new Article(null, "Samsung Galaxy Tab A7", 300, tablet));
        articleRepository.save(new Article(null, "Crucial Ballistix 32GB DDR4 RAM", 200, composant));
        articleRepository.save(new Article(null, "Bose SoundLink Mini II", 200, audio));
        articleRepository.save(new Article(null, "Call of Duty: Warzone", 200, jeuxVideo));
        articleRepository.save(new Article(null, "OnePlus Nord N10", 300, smartphone));
        articleRepository.save(new Article(null, "Lenovo Legion 7i", 1800, pc));
        articleRepository.save(new Article(null, "Amazon Fire 7", 520, tablet));
        articleRepository.save(new Article(null, "EVGA GeForce RTX 3080", 700, composant));
        articleRepository.save(new Article(null, "Sony WF-1000XM3", 200, audio));
        articleRepository.save(new Article(null, "League of Legends", 200, jeuxVideo));
        articleRepository.save(new Article(null, "Xiaomi Mi 11", 700, smartphone));
        articleRepository.save(new Article(null, "MSI GS66 Stealth", 2000, pc));
        articleRepository.save(new Article(null, "Lenovo Tab M10 Plus", 250, tablet));
        articleRepository.save(new Article(null, "Gigabyte Aorus GeForce RTX 3090", 1500, composant));
        articleRepository.save(new Article(null, "Beats Solo Pro", 300, audio));
        articleRepository.save(new Article(null, "Minecraft 2024", 200, jeuxVideo));
        articleRepository.save(new Article(null, "Huawei P40 Pro", 850, smartphone));
        articleRepository.save(new Article(null, "Razer Blade 15", 1800, pc));
        articleRepository.save(new Article(null, "Samsung Galaxy Tab S6 Lite", 400, tablet));
        articleRepository.save(new Article(null, "Intel Core i9-10900K", 500, composant));
        articleRepository.save(new Article(null, "Audio-Technica ATH-M50X", 150, audio));
        articleRepository.save(new Article(null, "Fortnite 2024", 190, jeuxVideo));
        articleRepository.save(new Article(null, "Google Pixel 6 Pro", 1000, smartphone));
        articleRepository.save(new Article(null, "Acer Predator Helios 300", 1000, pc));
        articleRepository.save(new Article(null, "Samsung Galaxy Tab S7+", 900, tablet));
        articleRepository.save(new Article(null, "Asus TUF Gaming GeForce GTX 1660 Super", 300, composant));
        articleRepository.save(new Article(null, "SteelSeries Arctis 7", 150, audio));
        articleRepository.save(new Article(null, "Apex Legends 2024", 130, jeuxVideo));
        articleRepository.save(new Article(null, "Xiaomi Redmi Note 10 Pro", 300, smartphone));
        articleRepository.save(new Article(null, "HP Pavilion Gaming Desktop", 800, pc));
        articleRepository.save(new Article(null, "Apple iPad Mini", 400, tablet));
        articleRepository.save(new Article(null, "NZXT Kraken X73", 150, composant));
        articleRepository.save(new Article(null, "Sony MDR-ZX110NC", 150, audio));
        articleRepository.save(new Article(null, "Valorant 2024", 150, jeuxVideo));

    }
}
