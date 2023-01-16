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

    @Column(name = "name")
    private String name;

    @Column(name = "image_link")
    private String imageLink;

    @Column(name = "image")
    private byte[] image;

    public Destinations() { }

    public Destinations(Long idDestinations, String name, String imageLink, byte[] image) {
        this.idDestinations = idDestinations;
        this.name = name;
        this.imageLink = imageLink;
        this.image = image;
    }

    public Long getIdDestinations() {
        return idDestinations;
    }

    public void setIdDestinations(Long idDestinations) {
        this.idDestinations = idDestinations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
