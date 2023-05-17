package br.com.web3clubtravel.blog.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.web3clubtravel.blog.config.exception.NotFoundException;
import br.com.web3clubtravel.blog.response.ResponseBase;

@RestControllerAdvice
public class ErrorHandling {
    
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ResponseBase<Void>> error404(NotFoundException ex) {
        final var base = ResponseBase.errorMessage(ex.getMessage());
        return ResponseEntity.status(404).body(base);
    }

}
