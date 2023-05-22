package br.com.web3clubtravel.blog.config;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseBase<List<ErrorFieldValidation>>> error400(MethodArgumentNotValidException ex) {
        final var errors = ex.getFieldErrors().stream().map(ErrorFieldValidation::new).toList();
        final var base = ResponseBase.of(
                errors,
                "Method Argument Not Valid",
                false);
        return ResponseEntity.status(404).body(base);
    }

    private record ErrorFieldValidation(String attribute, String message) {
        public ErrorFieldValidation(FieldError e) {
            this(e.getField(), e.getDefaultMessage());
        }
    }

}
