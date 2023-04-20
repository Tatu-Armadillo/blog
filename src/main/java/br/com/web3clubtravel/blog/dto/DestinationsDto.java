package br.com.web3clubtravel.blog.dto;

import java.util.List;

import br.com.web3clubtravel.blog.model.Destinations;

public class DestinationsDto {

    private Long idDestinations;
    private String title;
    private String nameCity;
    private List<ReferenceDto> references;

    public DestinationsDto() {
    }

    public DestinationsDto(Long idDestination, String title, String nameCity) {
        this.idDestinations = idDestination;
        this.title = title;
        this.nameCity = nameCity;
    }

    public static DestinationsDto of(Destinations destination) {
        final var dto = new DestinationsDto(
                destination.getIdDestinations(),
                destination.getTitle(),
                destination.getCity().getName());

        if (destination.getReferences() != null && !destination.getReferences().isEmpty()) {
            dto.setReferences(destination.getReferences().stream().map(ReferenceDto::of).toList());
        }
        return dto;
    }

    public Long getIdDestinations() {
        return idDestinations;
    }

    public void setIdDestinations(Long idDestinations) {
        this.idDestinations = idDestinations;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public List<ReferenceDto> getReferences() {
        return references;
    }

    public void setReferences(List<ReferenceDto> references) {
        this.references = references;
    }

}
