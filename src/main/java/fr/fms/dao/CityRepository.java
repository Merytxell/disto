package fr.fms.dao;

import fr.fms.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityRepository extends JpaRepository <City, Long> {


   List <City>findByCityName(String cityName);
}
