package br.com.web3clubtravel.blog.record.news;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.web3clubtravel.blog.model.News;
import br.com.web3clubtravel.blog.model.SubNews;

public record NewsRecord(
        Long idNews,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime dateTime,
        String title,
        String text,
        String imageLink) {

    public static NewsRecord of(News news) {
        return new NewsRecord(
                news.getIdNews(),
                news.getDateTime(),
                news.getTitle(),
                news.getText(),
                news.getImageLink());
    }
    
    public static NewsRecord of(SubNews suNews) {
        return new NewsRecord(
                suNews.getIdSubNews(),
                suNews.getNews().getDateTime(),
                suNews.getSubTitle(),
                suNews.getText(),
                suNews.getImageLink());
    }

}
