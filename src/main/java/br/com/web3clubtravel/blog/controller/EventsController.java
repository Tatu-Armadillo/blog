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

import br.com.web3clubtravel.blog.dto.EventsDto;
import br.com.web3clubtravel.blog.response.ResponseBase;
import br.com.web3clubtravel.blog.response.ResponseBasePaginado;
import br.com.web3clubtravel.blog.service.EventsServices;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/events")
public class EventsController {

    private final EventsServices eventsServices;

    @Autowired
    public EventsController(final EventsServices eventsServices) {
        this.eventsServices = eventsServices;
    }

    @GetMapping
    public ResponseEntity<ResponseBasePaginado<List<EventsDto>>> listNews(
            @PageableDefault(sort = "startDate", direction = Direction.ASC) Pageable pageable) {
        final var response = this.eventsServices.ListEvents(pageable);
        final var base = ResponseBasePaginado.of(response);
        return ResponseEntity.ok(base);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ResponseBase<EventsDto>> save(@RequestBody EventsDto dto) {
        final var reponse = this.eventsServices.save(dto);
        final var base = ResponseBase.of(reponse);
        return ResponseEntity.ok(base);
    }

}
