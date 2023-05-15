package br.com.web3clubtravel.blog.record;

import br.com.web3clubtravel.blog.model.Reference;

public record ReferenceRecord(
        String keyReference,
        String valor,
        String imageLink) {

    public static ReferenceRecord of(Reference reference) {
        return new ReferenceRecord(reference.getKeyReference(), reference.getValor(), reference.getImageLink());
    }

}
