package br.com.web3clubtravel.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.web3clubtravel.blog.model.User;
import br.com.web3clubtravel.blog.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(
            final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        final var reponse = this.userRepository.save(user);
        return reponse;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findByUsername(username);
    }

    public UserDetails findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

}
