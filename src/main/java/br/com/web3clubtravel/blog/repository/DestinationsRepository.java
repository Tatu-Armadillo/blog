package br.com.web3clubtravel.blog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.web3clubtravel.blog.model.Destinations;

@Repository
public interface DestinationsRepository extends JpaRepository<Destinations, Long> {

    @Query("SELECT destination FROM Destinations destination "
            + " INNER JOIN city c "
            + " WHERE c.name = :filter ")
    Page<Destinations> findByNameCity(Pageable pageable, @Param("filter") String filter);

}
