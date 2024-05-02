package fr.fms.dao;

import fr.fms.entities.Cinema;
import fr.fms.entities.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CinemaRepository extends JpaRepository<Cinema,Long> {

    Page<Cinema> findByCityId(Long idCity, Pageable pageable);


    Page<Cinema> findByCinemaNameContainingIgnoreCase(String kw, Pageable pageable);

    Page<Cinema> findByCityCityNameIgnoreCase(String city, Pageable pageable);

    List<Cinema> findByCity(City city);
}
