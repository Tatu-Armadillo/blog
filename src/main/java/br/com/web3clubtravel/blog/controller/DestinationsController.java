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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.web3clubtravel.blog.dto.DestinationsDto;
import br.com.web3clubtravel.blog.response.ResponseBase;
import br.com.web3clubtravel.blog.response.ResponseBasePaginado;
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

    @GetMapping
    public ResponseEntity<ResponseBasePaginado<List<DestinationsDto>>> listDestinationsWithFilter(
            @PageableDefault(sort = "city.name", direction = Direction.ASC) Pageable pageable,
            @RequestParam(required = false, defaultValue = "") final String filter) {
        final var response = this.destinationService.listDestinationsWithFilter(pageable, filter);
        final var base = ResponseBasePaginado.of(response);
        return ResponseEntity.ok(base);
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
