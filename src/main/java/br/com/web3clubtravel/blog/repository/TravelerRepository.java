package br.com.web3clubtravel.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.web3clubtravel.blog.model.Traveler;

@Repository
public interface TravelerRepository extends JpaRepository<Traveler, Long> {

    @Query("SELECT traveler FROM Traveler traveler "
            + " JOIN traveler.user user "
            + " WHERE user.username = :username")
    Optional<Traveler> getTravelerByUserName(@Param("username") String username);

}
