package br.com.web3clubtravel.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.web3clubtravel.blog.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
