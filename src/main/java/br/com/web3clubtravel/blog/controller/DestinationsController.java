package br.com.web3clubtravel.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.web3clubtravel.blog.dto.DestinationsDto;
import br.com.web3clubtravel.blog.response.ResponseBase;
import br.com.web3clubtravel.blog.service.DestinationService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/destinations")
public class DestinationsController {

    private final DestinationService destinationService;

    @Autowired
    public DestinationsController(final DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ResponseBase<DestinationsDto>> save(
            @RequestBody DestinationsDto dto) {
        final var destination = this.destinationService.save(dto);
        final var response = DestinationsDto.of(destination);
        final var base = ResponseBase.of(response);
        return ResponseEntity.ok(base);
    }

}
