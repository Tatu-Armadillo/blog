package br.com.web3clubtravel.blog.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "destinations")
public class Destinations {

    @Id
    @Column(name = "id_destinations")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDestinations;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @Column(name = "city")
    private String city;

    @Column(name = "image_link")
    private String imageLink;

    @Column(name = "image")
    private byte[] image;

    public Destinations() { }

    public Destinations(Long idDestinations, String country, String state, String city, String imageLink,
            byte[] image) {
        this.idDestinations = idDestinations;
        this.country = country;
        this.state = state;
        this.city = city;
        this.imageLink = imageLink;
        this.image = image;
    }

    public Long getIdDestinations() {
        return idDestinations;
    }

    public void setIdDestinations(Long idDestinations) {
        this.idDestinations = idDestinations;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

}
