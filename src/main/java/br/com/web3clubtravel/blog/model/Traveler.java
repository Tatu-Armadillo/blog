package br.com.web3clubtravel.blog.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "traveler")
public class Traveler {

    @Id
    @Column(name = "id_traveler")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTraveler;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "image_link")
    private String imageLink;

    @Column(name = "image")
    private byte[] image;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user", referencedColumnName = "id_user")
    private User user;

    public Traveler() { }

    public Traveler(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
    
    public Traveler(String name, String phone, String email, User user) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.user = user;
    }

    public Long getIdTraveler() {
        return idTraveler;
    }

    public void setIdTraveler(Long idTraveler) {
        this.idTraveler = idTraveler;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}
