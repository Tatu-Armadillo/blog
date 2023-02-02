package br.com.web3clubtravel.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.web3clubtravel.blog.model.User;
import br.com.web3clubtravel.blog.repository.PermissionRepository;
import br.com.web3clubtravel.blog.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PermissionRepository permissionRepository;

    @Autowired
    public UserService(
            final UserRepository userRepository,
            final PermissionRepository permissionRepository) {
        this.userRepository = userRepository;
        this.permissionRepository = permissionRepository;
    }

    public User save(User user) {
        final var permission = this.permissionRepository.getPermissionByDescription("traveler");
        user.setPermissions(List.of(permission));
        final var reponse = this.userRepository.save(user);
        return reponse;
    }

}
