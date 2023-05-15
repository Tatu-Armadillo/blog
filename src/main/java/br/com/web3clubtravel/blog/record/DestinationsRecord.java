package br.com.web3clubtravel.blog.record;

import java.util.List;

import br.com.web3clubtravel.blog.model.Destinations;

public record DestinationsRecord(
        Long idDestinations,
        String title,
        String nameCity,
        List<ReferenceRecord> references) {

    public static DestinationsRecord of(Destinations destination) {
        return new DestinationsRecord(
                destination.getIdDestinations(),
                destination.getTitle(),
                destination.getCity().getName(),
                destination.getReferences() != null
                        ? destination.getReferences().stream().map(ReferenceRecord::of).toList()
                        : null);
    }

}
