package br.com.web3clubtravel.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.web3clubtravel.blog.dto.CityDto;
import br.com.web3clubtravel.blog.response.ResponseBasePaginado;
import br.com.web3clubtravel.blog.service.CityService;

@RestController
@RequestMapping("/city")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(final CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public ResponseEntity<ResponseBasePaginado<List<CityDto>>> getCities(
            @PageableDefault(sort = "name", direction = Direction.ASC) Pageable pageable,
            @RequestParam(required = false, defaultValue = "") final String name) {
        final var reponse = this.cityService.getCitiesDto(pageable, name);
        final var base = ResponseBasePaginado.of(reponse);
        return ResponseEntity.ok(base);
    }

}
