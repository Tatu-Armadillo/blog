package br.com.web3clubtravel.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ResponseEntity<ResponseBase<TravelerDto>> getKingTraveler() {
        var response = this.travelerService.getKingTraveler();
        final var base = ResponseBase.of(response);
        return ResponseEntity.ok(base);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ResponseBase<TravelerDto>> save(
            @RequestBody final TravelerDto dto) {
        final var response = this.travelerService.save(dto);
        final var base = ResponseBase.of(response);
        return ResponseEntity.ok(base);
    }

}
