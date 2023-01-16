package br.com.web3clubtravel.blog.dto;

import br.com.web3clubtravel.blog.model.Destinations;

public class DestinationsDto {

    private String country;
    private String state;
    private String city;
    private String imageLink;

    public DestinationsDto(String city) {
        this.city = city;
    }

    public DestinationsDto(String country, String state, String city, String imageLink) {
        this.country = country;
        this.state = state;
        this.city = city;
        this.imageLink = imageLink;
    }

    public static DestinationsDto of(Destinations destination) {
        return new DestinationsDto(destination.getCountry(), destination.getState(), destination.getCity(),
                destination.getImageLink());
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

}
