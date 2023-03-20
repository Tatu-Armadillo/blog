package br.com.web3clubtravel.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.web3clubtravel.blog.dto.EventsDto;
import br.com.web3clubtravel.blog.response.ResponseBase;
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

    @PostMapping
    @Transactional
    public ResponseEntity<ResponseBase<EventsDto>> save(@RequestBody EventsDto dto) {
        final var reponse = this.eventsServices.save(dto);
        final var base = ResponseBase.of(reponse);
        return ResponseEntity.ok(base);
    }

}
