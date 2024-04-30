package fr.fms;

import fr.fms.dao.*;
import fr.fms.entities.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringStockMvcSecApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(SpringStockMvcSecApplication.class);



    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;
    private final CityRepository cityRepository;
    private final CinemaRepository cinemaRepository;
    private final MovieRepository movieRepository;

    @Autowired
    public SpringStockMvcSecApplication(CinemaRepository cinemaRepository, CityRepository cityRepository,MovieRepository movieRepository, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.cinemaRepository = cinemaRepository;
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
        this.roleRepository = roleRepository;
        this.cityRepository= cityRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringStockMvcSecApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        City Toulouse = cityRepository.save(new City(null,"Toulouse", null));
        City Dax = cityRepository.save(new City(null,"Dax",null));
        City Mugron = cityRepository.save(new City("Mugron"));


       Cinema UGC = cinemaRepository.save(new Cinema(null,"UGC","Montaudran", Toulouse, null));
       Cinema  PATHE = cinemaRepository.save(new Cinema(null,"Pathe"," place Wilson", Toulouse,null));
       Cinema ENTRACTE = cinemaRepository.save(new Cinema(null,"L'entracte","place du central",Mugron,null));
       Cinema GAUMONT = cinemaRepository.save(new Cinema(null,"Gaumont","rue des fleurs",Dax,null));

        movieRepository.save(new Movie(null,"Jurassic Parc",10 , "01/05 à 14h", UGC));
        movieRepository.save(new Movie(null,"Jurassic Parc",10, "04/05 à 10h",ENTRACTE));
        movieRepository.save(new Movie(null,"Harry Potter",10 , "04/05 à 11h", PATHE));
        movieRepository.save(new Movie(null,"Harry Potter",10 , "03/05 à 20h", GAUMONT));
        movieRepository.save(new Movie(null,"Barbie",10 ,"03/05 à 20h", GAUMONT));
        movieRepository.save(new Movie(null,"L'étrange Noël de Monsieur Jack",10,"05/05 à 10h",ENTRACTE ));



//        articleRepository.save(new Article(null, "Samsung S8 2024", 250, smartphone, null));
//        articleRepository.save(new Article(null, "HP Pavilion Laptop", 700, pc, null));
//        articleRepository.save(new Article(null, "iPad Pro 12.9", 1000, tablet, null));
//        articleRepository.save(new Article(null, "AMD Ryzen 7 5800X", 450, composant, null));
//        articleRepository.save(new Article(null, "Bose QuietComfort 35 II", 300, audio, null));
//        articleRepository.save(new Article(null, "FIFA 25 2024", 160, jeuxVideo, null));
//        articleRepository.save(new Article(null, "iPhone 13 Pro", 1100, smartphone, null));
//        articleRepository.save(new Article(null, "Dell XPS 15", 1500, pc, null));
//        articleRepository.save(new Article(null, "Samsung Galaxy Tab S7", 800, tablet, null));
//        articleRepository.save(new Article(null, "NVIDIA GeForce RTX 3080", 700, composant, null));
//        articleRepository.save(new Article(null, "Sony WH-1000XM4", 350, audio, null));

//        articleRepository.save(new Article(null, "Asus ROG Zephyrus G14", 1200, pc, null));
//        articleRepository.save(new Article(null, "Amazon Fire HD 10", 200, tablet, null));
//        articleRepository.save(new Article(null, "Corsair Vengeance RGB Pro 16GB", 120, composant, null));
//        articleRepository.save(new Article(null, "JBL Flip 5 2024", 100, audio, null));
//        articleRepository.save(new Article(null, "The Last of Us Part II", 140, jeuxVideo, null));
//        articleRepository.save(new Article(null, "OnePlus 9 Pro", 800, smartphone, null));
//        articleRepository.save(new Article(null, "Microsoft Surface Laptop 4", 1300, pc, null));
//        articleRepository.save(new Article(null, "Lenovo Tab M10 Plus", 250, tablet, null));
//        articleRepository.save(new Article(null, "Western Digital Blue 1TB SSD", 150, composant, null));
//        articleRepository.save(new Article(null, "Apple AirPods Pro", 250, audio, null));
//        articleRepository.save(new Article(null, "Assassin's Creed Valhalla", 155, jeuxVideo, null));
//        articleRepository.save(new Article(null, "Xiaomi Mi 11 2024", 700, smartphone, null));
//        articleRepository.save(new Article(null, "Acer Predator Helios 300", 1000, pc, null));
//        articleRepository.save(new Article(null, "Samsung Galaxy Tab A7", 300, tablet, null));
//        articleRepository.save(new Article(null, "Crucial Ballistix 32GB DDR4 RAM", 200, composant, null));
//        articleRepository.save(new Article(null, "Sennheiser HD 650", 400, audio, null));
//        articleRepository.save(new Article(null, "Minecraft 2024", 120, jeuxVideo, null));
//        articleRepository.save(new Article(null, "Google Pixel 5a", 600, smartphone, null));
//        articleRepository.save(new Article(null, "Razer Blade 15", 1800, pc, null));
//        articleRepository.save(new Article(null, "Amazon Fire 7", 150, tablet, null));
//        articleRepository.save(new Article(null, "Seagate BarraCuda 2TB HDD", 180, composant, null));
//        articleRepository.save(new Article(null, "Bose SoundLink Mini II", 200, audio, null));
//        articleRepository.save(new Article(null, "Grand Theft Auto V", 130, jeuxVideo, null));
//        articleRepository.save(new Article(null, "Huawei P40 Pro", 850, smartphone, null));
//        articleRepository.save(new Article(null, "Alienware m15 R4", 2200, pc, null));
//        articleRepository.save(new Article(null, "Lenovo Tab P11", 350, tablet, null));
//        articleRepository.save(new Article(null, "EVGA GeForce GTX 1660 Super", 300, composant, null));
//        articleRepository.save(new Article(null, "Jabra Elite 85t", 300, audio, null));
//        articleRepository.save(new Article(null, "Red Dead Redemption 2", 140, jeuxVideo, null));
//        articleRepository.save(new Article(null, "OnePlus 8T 2024", 700, smartphone, null));
//        articleRepository.save(new Article(null, "MSI GS66 Stealth", 2000, pc, null));
//        articleRepository.save(new Article(null, "Samsung Galaxy Tab S6 Lite", 400, tablet, null));
//        articleRepository.save(new Article(null, "AMD Radeon RX 6700 XT", 600, composant, null));
//        articleRepository.save(new Article(null, "Sony WF-1000XM4 2024", 280, audio, null));
//        articleRepository.save(new Article(null, "Overwatch 2024", 140, jeuxVideo, null));
//        articleRepository.save(new Article(null, "Xiaomi Mi 11 Ultra", 1200, smartphone, null));
//        articleRepository.save(new Article(null, "Razer Blade Stealth 13", 1500, pc, null));
//        articleRepository.save(new Article(null, "Apple iPad Air", 600, tablet, null));
//        articleRepository.save(new Article(null, "NZXT Kraken X73", 150, composant, null));
//        articleRepository.save(new Article(null, "Anker Soundcore Liberty Air 2 Pro", 130, audio, null));
//        articleRepository.save(new Article(null, "Fortnite 2024", 100, jeuxVideo, null));
//        articleRepository.save(new Article(null, "Google Pixel 6 Pro", 1000, smartphone, null));
//        articleRepository.save(new Article(null, "MSI GE76 Raider", 2500, pc, null));
//        articleRepository.save(new Article(null, "Samsung Galaxy Tab S7+", 900, tablet, null));
//        articleRepository.save(new Article(null, "Gigabyte GeForce RTX 3060", 400, composant, null));
//        articleRepository.save(new Article(null, "SteelSeries Arctis 7", 150, audio, null));
//        articleRepository.save(new Article(null, "League of Legends", 100, jeuxVideo, null));
//
//        articleRepository.findAll().forEach(a -> logger.info(a.toString()));

        generateData();
    }

    public void generateData() {
        Role user = roleRepository.save(new Role("users", null));
        Role admin = roleRepository.save(new Role("admins", null));

        createUserWithRoles("fred2024", "fmsAcad@2024$", true, admin, user);
        createUserWithRoles("Josette", "@Pelote2024!", true, user);

    }

    private void createUserWithRoles(String username, String password, boolean active, Role... roles) {
        List<Role> userRoles = Arrays.asList(roles);
        String encodedPassword = passwordEncoder.encode(password);
        userRepository.save(new User(username, encodedPassword, active, userRoles, null));
    }

}

