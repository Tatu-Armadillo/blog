package br.com.web3clubtravel.blog.exception;

public class NegocioException extends RuntimeException {

    public NegocioException(final String mensagem, final String... param) {
        super(mensagem);
    }

}
