package br.com.web3clubtravel.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.web3clubtravel.blog.model.Destinations;

@Repository
public interface DestinationsRepository extends JpaRepository<Destinations, Long> {

    @Query("SELECT destination FROM Destinations destination "
            + " INNER JOIN city c "
            + " WHERE c.name = :city ")
    Optional<Destinations> findByNameCity(@Param("city") String city);
}
