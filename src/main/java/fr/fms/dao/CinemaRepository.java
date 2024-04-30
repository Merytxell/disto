package fr.fms.dao;

import fr.fms.entities.Cinema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema,Long> {

    Page<Cinema> findByCityId(Long idCity, PageRequest of);

    Page<Cinema> findByCinemaName(String kw, PageRequest of);
}
