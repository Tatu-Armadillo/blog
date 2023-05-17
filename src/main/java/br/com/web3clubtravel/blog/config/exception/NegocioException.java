package br.com.web3clubtravel.blog.config.exception;

public class NegocioException extends RuntimeException {

    public NegocioException(final String message, final String... param) {
        super(message);
    }

}
