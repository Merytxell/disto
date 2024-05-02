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

