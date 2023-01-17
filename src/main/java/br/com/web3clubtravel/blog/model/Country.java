package br.com.web3clubtravel.blog.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "id_country")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCountry;

    @Column(name = "portuguese_name")
    private String portugueseName;

    @Column(name = "english_name")
    private String englishName;

    @Column(name = "image_link")
    private String imageLink;

    @Column(name = "image")
    private byte[] image;

    public Country() { }

    public Country(String portugueseName, String englishName, String imageLink) {
        this.portugueseName = portugueseName;
        this.englishName = englishName;
        this.imageLink = imageLink;
    }

    public Long getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Long idCountry) {
        this.idCountry = idCountry;
    }

    public String getPortugueseName() {
        return portugueseName;
    }

    public void setPortugueseName(String portugueseName) {
        this.portugueseName = portugueseName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
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
