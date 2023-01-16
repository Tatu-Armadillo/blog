package br.com.web3clubtravel.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.web3clubtravel.blog.dto.NewsDto;
import br.com.web3clubtravel.blog.response.ResponseBase;
import br.com.web3clubtravel.blog.response.ResponseBasePaginado;
import br.com.web3clubtravel.blog.service.NewsService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public ResponseEntity<ResponseBasePaginado<List<NewsDto>>> listNews(
            @PageableDefault(sort = "dateTime", direction = Direction.ASC) Pageable pageable) {
        final var response = this.newsService.listNews(pageable);
        final var base = ResponseBasePaginado.of(response);
        return ResponseEntity.ok(base);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ResponseBase<NewsDto>> save(@RequestBody NewsDto newsDto) {
        final var response = this.newsService.save(newsDto);
        final var base = ResponseBasePaginado.of(response);
        return ResponseEntity.ok(base);
    }
}
