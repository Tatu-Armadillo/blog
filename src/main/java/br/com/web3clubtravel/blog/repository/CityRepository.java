package br.com.web3clubtravel.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.web3clubtravel.blog.model.City;

public interface CityRepository extends JpaRepository<City, Long> {
    
    @Query("SELECT city FROM City city "
            + " WHERE name = :city ")
    Optional<City> findByNameCity(@Param("city") String city);
}
