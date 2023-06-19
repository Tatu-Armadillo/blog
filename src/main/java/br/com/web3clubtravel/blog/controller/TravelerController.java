package br.com.web3clubtravel.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.web3clubtravel.blog.record.TravelerRecord;
import br.com.web3clubtravel.blog.response.ResponseBase;
import br.com.web3clubtravel.blog.service.TravelerService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/traveler")
@Tag(name = "Traveler", description = "Endpoints for Create a new traveler")
public class TravelerController {

    private final TravelerService travelerService;

    @Autowired
    public TravelerController(final TravelerService travelerService) {
        this.travelerService = travelerService;
    }

    @PostMapping
    @Transactional
    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Add a new traveler", description = "Add a new traveler", tags = { "Traveler" }, responses = {
            @ApiResponse(description = "Create", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TravelerRecord.class))),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public ResponseEntity<ResponseBase<TravelerRecord>> save(
            @Valid @RequestBody TravelerRecord record) {
        final var response = this.travelerService.save(record);
        final var base = ResponseBase.of(TravelerRecord.of(response));
        return ResponseEntity.ok(base);
    }

}
