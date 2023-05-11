package br.com.web3clubtravel.blog.record;

import jakarta.validation.constraints.NotBlank;

public record ContactRecord(
        @NotBlank(message = "Required attribute <name>") String name,
        @NotBlank(message = "Required attribute <phone>") String phone,
        @NotBlank(message = "Required attribute <email>") String email) {
}
