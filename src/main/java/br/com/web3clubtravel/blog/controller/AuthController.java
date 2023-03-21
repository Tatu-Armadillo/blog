package br.com.web3clubtravel.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.web3clubtravel.blog.dto.UserDto;
import br.com.web3clubtravel.blog.exception.NegocioException;
import br.com.web3clubtravel.blog.response.ResponseBase;
import br.com.web3clubtravel.blog.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private static final String message = "Invalid client request!";

    @Autowired
    public AuthController(final UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signin")
    public ResponseEntity<ResponseBase<UserDto>> signin(@RequestBody UserDto data) {
        if (data == null
                || data.getUsername() == null || data.getUsername().isBlank()
                || data.getPassword() == null || data.getPassword().isBlank()) {
            throw new NegocioException(message);
        }

        final var reponse = this.userService.previaLogin(data);
        final var base = ResponseBase.of(reponse);
        return ResponseEntity.ok(base);
    }

}
