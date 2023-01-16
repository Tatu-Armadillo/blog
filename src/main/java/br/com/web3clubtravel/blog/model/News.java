package br.com.web3clubtravel.blog.model;

import java.time.LocalDateTime;

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
@Table(name = "news")
public class News {

    @Id
    @Column(name = "id_news")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNews;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @Column(name = "subtitle")
    private String subtitle;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "image_link")
    private String imageLink;

    @Column(name = "image")
    private byte[] image;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "destinations", foreignKey = @ForeignKey(name = "fk_destinations_news"))
    private Destinations destination;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "traveler", foreignKey = @ForeignKey(name = "fk_traveler_news"))
    private Traveler traveler;

    public News() { }

    public News(String title, String text, String subtitle, LocalDateTime dateTime,
            Destinations destination, Traveler traveler) {
        this.title = title;
        this.text = text;
        this.subtitle = subtitle;
        this.dateTime = dateTime;
        this.destination = destination;
        this.traveler = traveler;
    }

    public Long getIdNews() {
        return idNews;
    }

    public void setIdNews(Long idNews) {
        this.idNews = idNews;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
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

    public Destinations getDestination() {
        return destination;
    }

    public void setDestination(Destinations destination) {
        this.destination = destination;
    }

    public Traveler getTraveler() {
        return traveler;
    }

    public void setTraveler(Traveler traveler) {
        this.traveler = traveler;
    }

}
