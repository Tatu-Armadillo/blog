package br.com.web3clubtravel.blog.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "destinations")
public class Destinations {

    @Id
    @Column(name = "id_destinations")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDestinations;

    @Column(name = "reference")
    private String reference;

    @Column(name = "image_link")
    private String imageLink;

    @Column(name = "image")
    private byte[] image;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city", foreignKey = @ForeignKey(name = "fk_city_destinations"))
    private City city;

    public Destinations() { }

    public Destinations(String reference, String imageLink, City city) {
        this.reference = reference;
        this.imageLink = imageLink;
        this.city = city;
    }

    public Long getIdDestinations() {
        return idDestinations;
    }

    public void setIdDestinations(Long idDestinations) {
        this.idDestinations = idDestinations;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}
