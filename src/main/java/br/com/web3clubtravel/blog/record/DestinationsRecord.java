package br.com.web3clubtravel.blog.record;

import java.util.List;

import br.com.web3clubtravel.blog.model.Destinations;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record DestinationsRecord(
        Long idDestinations,
        @NotBlank(message = "Required attribute <nameCity>") String nameCity,
        @Valid List<ReferenceRecord> references) {

    public static DestinationsRecord of(Destinations destination) {
        return new DestinationsRecord(
                destination.getIdDestinations(),
                destination.getCity().getName(),
                destination.getReferences() != null
                        ? destination.getReferences().stream().map(ReferenceRecord::of).toList()
                        : null);
    }

}
