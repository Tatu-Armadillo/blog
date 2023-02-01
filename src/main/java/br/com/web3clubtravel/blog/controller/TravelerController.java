package br.com.web3clubtravel.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.web3clubtravel.blog.dto.TravelerDto;
import br.com.web3clubtravel.blog.response.ResponseBase;
import br.com.web3clubtravel.blog.service.TravelerService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/traveler")
public class TravelerController {

    private final TravelerService travelerService;

    @Autowired
    public TravelerController(final TravelerService travelerService) {
        this.travelerService = travelerService;
    }

    @GetMapping
    public ResponseEntity<ResponseBase<TravelerDto>> getTraveler(
            @RequestParam(required = true, defaultValue = "king") final String username) {
        final var traveler = this.travelerService.getTraveler(username);
        final var response = TravelerDto.of(traveler);
        final var base = ResponseBase.of(response);
        return ResponseEntity.ok(base);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ResponseBase<TravelerDto>> save(
            @RequestBody final TravelerDto dto,
            @RequestParam(required = true) final Boolean isContact) {
        final var response = this.travelerService.save(dto, isContact);
        final var base = ResponseBase.of(response);
        return ResponseEntity.ok(base);
    }

}
