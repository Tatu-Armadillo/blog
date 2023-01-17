package br.com.web3clubtravel.blog.dto;

import br.com.web3clubtravel.blog.model.City;
import br.com.web3clubtravel.blog.model.Destinations;

public class DestinationsDto {

    private String reference;
    private String imageLink;
    private City city;

    public DestinationsDto(City city) {
        this.city = city;
    }

    public DestinationsDto(String reference, String imageLink, City city) {
        this.reference = reference;
        this.city = city;
        this.imageLink = imageLink;
    }

    public static DestinationsDto of(Destinations destination) {
        return new DestinationsDto(destination.getReference(), destination.getImageLink(), destination.getCity());
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}
