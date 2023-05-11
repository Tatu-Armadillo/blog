package br.com.web3clubtravel.blog.record;

import br.com.web3clubtravel.blog.model.Traveler;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record TravelerRecord(
        @Valid ContactRecord contact,
        @NotBlank(message = "Required attribute <password>") String password) {

    public static TravelerRecord of(Traveler traveler) {
        return new TravelerRecord(ContactRecord.of(traveler.getContact()), null);
    }
}
