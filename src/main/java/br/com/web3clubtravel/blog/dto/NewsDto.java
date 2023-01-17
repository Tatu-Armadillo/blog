package br.com.web3clubtravel.blog.dto;

import java.time.LocalDateTime;

import br.com.web3clubtravel.blog.model.News;

public class NewsDto {

    private String title;
    private String text;
    private String subtitle;
    private LocalDateTime dateTime;
    private String imageLink;
    private DestinationsDto destinations;
    private TravelerDto traveler;

    public NewsDto() { }

    public NewsDto(String title, String text, String subtitle, String imageLink, 
    DestinationsDto destinations,
            TravelerDto traveler) {
        this.title = title;
        this.text = text;
        this.subtitle = subtitle;
        this.imageLink = imageLink;
        this.destinations = destinations;
        this.traveler = traveler;
    }

    public static NewsDto of(News news) {
        return new NewsDto(
                news.getTitle(),
                news.getText(),
                news.getSubtitle(),
                news.getImageLink(),
                DestinationsDto.of(news.getDestination()), 
                TravelerDto.of(news.getTraveler()));
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

    public DestinationsDto getDestinations() {
        return destinations;
    }

    public void setDestinations(DestinationsDto destinations) {
        this.destinations = destinations;
    }

    public TravelerDto getTraveler() {
        return traveler;
    }

    public void setTraveler(TravelerDto traveler) {
        this.traveler = traveler;
    }
}
