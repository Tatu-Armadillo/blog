package br.com.web3clubtravel.blog.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.web3clubtravel.blog.exception.NegocioException;
import br.com.web3clubtravel.blog.model.News;
import br.com.web3clubtravel.blog.record.news.NewsRecord;
import br.com.web3clubtravel.blog.record.news.NewsRecordList;
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

    public Page<NewsRecord> listNews(Pageable pageable) {
        return this.newsRepository.findAll(pageable).map(NewsRecord::of);
    }

    public NewsRecordList showNews(final Long idNews) {
        var newsDto = this.findById(idNews);
        return NewsRecordList.of(newsDto);
    }

    public NewsRecord save(NewsRecordList dto) {
        var newsDto = dto.newsRecord();
        final var news = new News(
                newsDto.title(),
                newsDto.text(),
                LocalDateTime.now(),
                newsDto.imageLink());
        final var dataNews = this.newsRepository.save(news);

        if (dto.subNews() != null && !dto.subNews().isEmpty()) {
            var subNewsDto = dto.subNews();
            this.subNewsService.save(subNewsDto, dataNews);
        }

        return NewsRecord.of(dataNews);
    }

}
