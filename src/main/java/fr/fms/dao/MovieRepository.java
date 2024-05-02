package fr.fms.dao;

import fr.fms.entities.Cinema;
import fr.fms.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface MovieRepository extends JpaRepository <Movie, Long> {
    List<Movie> findByCinema(Cinema cinema);

    String findByDate(Movie movie);

    String findByPrice(Movie movie);
}
