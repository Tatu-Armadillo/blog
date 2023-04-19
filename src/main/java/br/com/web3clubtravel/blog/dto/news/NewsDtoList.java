package br.com.web3clubtravel.blog.dto.news;

import java.util.List;
import java.util.ArrayList;

import br.com.web3clubtravel.blog.model.News;
import br.com.web3clubtravel.blog.model.SubNews;

public class NewsDtoList {

    public NewsDto newsDto;
    private List<NewsDto> subNews;

    public NewsDtoList() { }

    public NewsDtoList(NewsDto newsDto, List<NewsDto> subNews) {
        this.newsDto = newsDto;
        this.subNews = subNews;
    }

    public static NewsDtoList of(News news) {
        var principalNews = NewsDto.of(news);
        var subnews = populateListNewsDto(news);
        return new NewsDtoList(principalNews, subnews);
    }

    private static List<NewsDto> populateListNewsDto(News news) {
        // TODO TRANSFORMAR EM UM COLECTION
        List<NewsDto> dtos = new ArrayList<>();
        for (SubNews subNews : news.getSubNews()) {
            var dto = new NewsDto(news.getIdNews(), subNews.getSubTitle(), subNews.getText(), news.getDateTime(),
                    subNews.getImageLink());
            dtos.add(dto);
        }
        return dtos;
    }

    public NewsDto getNewsDto() {
        return newsDto;
    }

    public void setNewsDto(NewsDto newsDto) {
        this.newsDto = newsDto;
    }

    public List<NewsDto> getSubNews() {
        return subNews;
    }

    public void setSubNews(List<NewsDto> subNews) {
        this.subNews = subNews;
    }

}
