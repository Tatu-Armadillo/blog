package br.com.web3clubtravel.blog.dto.news;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.web3clubtravel.blog.model.News;

public class NewsDto {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime;
    private Long idNews;
    private String title;
    private String text;
    private String imageLink;

    public NewsDto() { }

    public NewsDto(Long idNews, String title, String text, LocalDateTime dateTime, String imageLink) {
        this.idNews = idNews;
        this.title = title;
        this.text = text;
        this.dateTime = dateTime;
        this.imageLink = imageLink;
    }

    public static NewsDto of(News news) {
        return new NewsDto(
                news.getIdNews(),
                news.getTitle(),
                news.getText(),
                news.getDateTime(),
                news.getImageLink());
    }

    public Long getIdNews() {
        return idNews;
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

}
