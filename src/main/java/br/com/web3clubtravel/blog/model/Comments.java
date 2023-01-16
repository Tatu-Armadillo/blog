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
@Table(name = "comments")
public class Comments {

    @Id
    @Column(name = "id_comments")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComments;

    @Column(name = "text")
    private String text;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "traveler", foreignKey = @ForeignKey(name = "fk_traveler_comments"))
    private Traveler traveler;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "news", foreignKey = @ForeignKey(name = "fk_news_comments"))
    private News news;

    public Comments() { }

    public Comments(Long idComments, String text, LocalDateTime dateTime, Traveler traveler, News news) {
        this.idComments = idComments;
        this.text = text;
        this.dateTime = dateTime;
        this.traveler = traveler;
        this.news = news;
    }

    public Long getIdComments() {
        return idComments;
    }

    public void setIdComments(Long idComments) {
        this.idComments = idComments;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Traveler getTraveler() {
        return traveler;
    }

    public void setTraveler(Traveler traveler) {
        this.traveler = traveler;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

}
