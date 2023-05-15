package br.com.web3clubtravel.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.web3clubtravel.blog.model.News;
import br.com.web3clubtravel.blog.model.SubNews;
import br.com.web3clubtravel.blog.record.news.NewsRecord;
import br.com.web3clubtravel.blog.repository.SubNewsRepository;

@Service
public class SubNewsService {

    private final SubNewsRepository subNewsRepository;

    @Autowired
    public SubNewsService(final SubNewsRepository subNewsRepository) {
        this.subNewsRepository = subNewsRepository;
    }

    public void save(List<NewsRecord> dtos, News news) {
        // TODO CRIAR UM CONSUMER
        for (NewsRecord dto : dtos) {
            var subNews = new SubNews(
                    dto.title(),
                    dto.text(),
                    dto.imageLink(),
                    null,
                    news);
            this.subNewsRepository.save(subNews);
        }
    }

}
