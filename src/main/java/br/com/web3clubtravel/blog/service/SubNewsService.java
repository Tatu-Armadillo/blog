package br.com.web3clubtravel.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.web3clubtravel.blog.dto.news.NewsDto;
import br.com.web3clubtravel.blog.model.News;
import br.com.web3clubtravel.blog.model.SubNews;
import br.com.web3clubtravel.blog.repository.SubNewsRepository;

@Service
public class SubNewsService {

    private final SubNewsRepository subNewsRepository;

    @Autowired
    public SubNewsService(final SubNewsRepository subNewsRepository) {
        this.subNewsRepository = subNewsRepository;
    }

    public void save(List<NewsDto> dtos, News news) {
        // TODO CRIAR UM CONSUMER
        for (NewsDto dto : dtos) {
            var subNews = new SubNews(
                    dto.getTitle(),
                    dto.getText(),
                    dto.getImageLink(),
                    null,
                    news);
            this.subNewsRepository.save(subNews);
        }
    }

}
