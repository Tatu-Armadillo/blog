package br.com.web3clubtravel.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.web3clubtravel.blog.config.exception.NegocioException;
import br.com.web3clubtravel.blog.dto.UserDto;
import br.com.web3clubtravel.blog.response.ResponseBase;
import br.com.web3clubtravel.blog.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth", description = "Endpoints for Login in application")
public class AuthController {

    private final UserService userService;
    private static final String message = "Invalid client request!";

    @Autowired
    public AuthController(final UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signin")
    @Operation(summary = "Make a request to the application", description = "Make a request to the application", 
        tags = { "Auth" }, 
        responses = {
            @ApiResponse(description = "Create", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
        )
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
