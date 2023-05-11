package br.com.web3clubtravel.blog.record;

import br.com.web3clubtravel.blog.model.Contact;
import jakarta.validation.constraints.NotBlank;

public record ContactRecord(
        @NotBlank(message = "Required attribute <name>") String name,
        @NotBlank(message = "Required attribute <phone>") String phone,
        @NotBlank(message = "Required attribute <email>") String email) {

    public static ContactRecord of(Contact contact) {
        return new ContactRecord(contact.getName(), contact.getPhone(), contact.getEmail());
    }
}
