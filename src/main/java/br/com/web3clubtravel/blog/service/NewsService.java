package br.com.web3clubtravel.blog.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.web3clubtravel.blog.dto.NewsDto;
import br.com.web3clubtravel.blog.model.News;
import br.com.web3clubtravel.blog.repository.NewsRepository;

@Service
public class NewsService {

    private final NewsRepository newsRepository;

    @Autowired
    public NewsService(final NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public Page<NewsDto> listNews(Pageable pageable) {
        return this.newsRepository.findAll(pageable).map(NewsDto::of);
    }

    public NewsDto save(NewsDto dto) {
        final var news = new News(
                dto.getTitle(),
                dto.getText(),
                LocalDateTime.now());
        final var response = this.newsRepository.save(news);
        return NewsDto.of(response);
    }

}
