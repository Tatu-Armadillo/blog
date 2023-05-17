package br.com.web3clubtravel.blog.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.web3clubtravel.blog.exception.NegocioException;
import br.com.web3clubtravel.blog.response.ResponseBase;

@RestControllerAdvice
public class ErrorHandling {
    
    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<ResponseBase<Void>> error404(NegocioException ex) {
        final var base = ResponseBase.errorMessage(ex.getMessage());
        return ResponseEntity.status(404).body(base);
    }

}
