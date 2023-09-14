package br.com.web3clubtravel.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.web3clubtravel.blog.config.security.TokenService;
import br.com.web3clubtravel.blog.model.User;
import br.com.web3clubtravel.blog.record.auth.TokenRecord;
import br.com.web3clubtravel.blog.record.auth.UserRecord;
import br.com.web3clubtravel.blog.response.ResponseBase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth", description = "Endpoints for Login in application")
public class AuthController {

    private final AuthenticationManager manager;
    private final TokenService tokenService;

    @Autowired
    public AuthController(final AuthenticationManager manager, final TokenService tokenService) {
        this.manager = manager;
        this.tokenService = tokenService;
    }

    @PostMapping("/signin")
    @Operation(summary = "Make a request to the application", description = "Make a request to the application", tags = {
            "Auth" }, responses = {
                    @ApiResponse(description = "Create", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TokenRecord.class))),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<ResponseBase<TokenRecord>> signin(@Valid @RequestBody UserRecord data) {
        final var authenticationToken = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        final var authentication = manager.authenticate(authenticationToken);
        final var tokenJWT = tokenService.createToken((User) authentication.getPrincipal());

        final var base = ResponseBase.of(new TokenRecord(data.username(), tokenJWT));
        return ResponseEntity.ok(base);
    }

}
