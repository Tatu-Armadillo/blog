package br.com.web3clubtravel.blog.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.web3clubtravel.blog.dto.news.NewsDto;
import br.com.web3clubtravel.blog.dto.news.NewsDtoList;
import br.com.web3clubtravel.blog.exception.NegocioException;
import br.com.web3clubtravel.blog.model.News;
import br.com.web3clubtravel.blog.repository.NewsRepository;

@Service
public class NewsService {

    private final NewsRepository newsRepository;
    private final SubNewsService subNewsService;

    @Autowired
    public NewsService(
            final NewsRepository newsRepository,
            final SubNewsService subNewsService) {
        this.newsRepository = newsRepository;
        this.subNewsService = subNewsService;
    }

    private News findById(final Long idNews) {
        return this.newsRepository.findById(idNews)
                .orElseThrow(() -> new NegocioException("News not Found"));
    }

    public Page<NewsDto> listNews(Pageable pageable) {
        return this.newsRepository.findAll(pageable).map(NewsDto::of);
    }

    public NewsDtoList showNews(final Long idNews) {
        var newsDto = this.findById(idNews);
        return NewsDtoList.of(newsDto);
    }

    public NewsDto save(NewsDtoList dto) {
        var newsDto = dto.getNewsDto();
        final var news = new News(
                newsDto.getTitle(),
                newsDto.getText(),
                LocalDateTime.now(),
                newsDto.getImageLink());
        final var dataNews = this.newsRepository.save(news);

        if (dto.getSubNews() != null && !dto.getSubNews().isEmpty()) {
            var subNewsDto = dto.getSubNews();
            this.subNewsService.save(subNewsDto, dataNews);
        }

        return NewsDto.of(dataNews);
    }

}
