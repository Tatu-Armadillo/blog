package br.com.web3clubtravel.blog.record.news;

import java.util.ArrayList;
import java.util.List;

import br.com.web3clubtravel.blog.model.News;
import br.com.web3clubtravel.blog.model.SubNews;
import jakarta.validation.Valid;

public record NewsRecordList(
        @Valid NewsRecord newsRecord,
        @Valid List<NewsRecord> subNews) {

    public static NewsRecordList of(News news) {
        var principalNews = NewsRecord.of(news);
        var subnews = populateListNewsDto(news);
        return new NewsRecordList(principalNews, subnews);
    }

    private static List<NewsRecord> populateListNewsDto(News news) {
        // TODO TRANSFORMAR EM UM COLECTION
        List<NewsRecord> dtos = new ArrayList<>();
        for (SubNews subNews : news.getSubNews()) {
            var dto = NewsRecord.of(subNews);
            dtos.add(dto);
        }
        return dtos;
    }
}
