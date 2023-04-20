package br.com.web3clubtravel.blog.dto;

import br.com.web3clubtravel.blog.model.Reference;

public class ReferenceDto {

    private String keyReference;
    private String valor;
    private String imageLink;

    public ReferenceDto() { }

    public ReferenceDto(String keyReference, String valor, String imageLink) {
        this.keyReference = keyReference;
        this.valor = valor;
        this.imageLink = imageLink;
    }

    public static ReferenceDto of(Reference reference) {
        return new ReferenceDto(
                reference.getKeyReference(),
                reference.getValor(),
                reference.getImageLink());
    }

    public String getKeyReference() {
        return keyReference;
    }

    public void setKeyReference(String keyReference) {
        this.keyReference = keyReference;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

}
