package br.com.web3clubtravel.blog.record;

import br.com.web3clubtravel.blog.model.Reference;
import jakarta.validation.constraints.NotBlank;

public record ReferenceRecord(
        @NotBlank(message = "Required attribute <keyReference>") String keyReference,
        @NotBlank(message = "Required attribute <valor>") String valor,
        String imageLink) {

    public static ReferenceRecord of(Reference reference) {
        return new ReferenceRecord(reference.getKeyReference(), reference.getValor(), reference.getImageLink());
    }

}
