package br.com.web3clubtravel.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/destinations")
@Tag(name = "Destinations", description = "Endpoints for consulting and create destinations")
public class DestinationsController {

    private final DestinationService destinationService;

    @Autowired
    public DestinationsController(final DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @GetMapping
    @Operation(summary = "responsible for list destinations ordered by city name", description = "list destinations ordered by city name", tags = {
            "Destinations" }, responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = {
                            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = DestinationsDto.class)))
                    }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            })
    public ResponseEntity<ResponseBasePaginado<List<DestinationsDto>>> listDestinationsWithFilter(
            @PageableDefault(sort = "city.name", direction = Direction.ASC) Pageable pageable,
            @RequestParam(required = false, defaultValue = "") final String cityName) {
        final var response = this.destinationService.listDestinationsWithFilter(pageable, cityName);
        final var base = ResponseBasePaginado.of(response);
        return ResponseEntity.ok(base);
    }

    @GetMapping("/{idDestination}")
    @Operation(summary = "Search the destination by ID and its references", description = "Search the destination by ID and its references", tags = {
            "News" }, responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = DestinationsDto.class))),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<ResponseBase<DestinationsDto>> showNews(@PathVariable final Long idDestination) {
        final var response = this.destinationService.findById(idDestination);
        final var base = ResponseBase.of(DestinationsDto.of(response));
        return ResponseEntity.ok(base);
    }

    @PostMapping
    @Transactional
    @Operation(summary = "Add a new destinations", description = "Add a new destinations", tags = {
            "Destinations" }, responses = {
                    @ApiResponse(description = "Create", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = DestinationsDto.class))),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<ResponseBase<DestinationsDto>> save(
            @RequestBody DestinationsDto dto) {
        final var destination = this.destinationService.save(dto);
        final var response = DestinationsDto.of(destination);
        final var base = ResponseBase.of(response);
        return ResponseEntity.ok(base);
    }

}
