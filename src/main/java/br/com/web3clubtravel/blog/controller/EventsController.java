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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/events")
@Tag(name = "Events", description = "Endpoints for consulting and create events")
public class EventsController {

    private final EventsServices eventsServices;

    @Autowired
    public EventsController(final EventsServices eventsServices) {
        this.eventsServices = eventsServices;
    }

    @GetMapping
    @Operation(summary = "responsible for list events ordered by creation date", description = "list new events ordered by creation date", 
                tags = { "Events" }, 
                responses = { 
                    @ApiResponse(description = "Success", responseCode = "200", 
                        content = {
                            @Content(mediaType = "application/json", 
                                array = 
                                    @ArraySchema(schema = @Schema(implementation = EventsDto.class))
                                    )
                                }
                            ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
                    }
                )
    public ResponseEntity<ResponseBasePaginado<List<EventsDto>>> listNews(
            @PageableDefault(sort = "startDate", direction = Direction.ASC) Pageable pageable) {
        final var response = this.eventsServices.ListEvents(pageable);
        final var base = ResponseBasePaginado.of(response);
        return ResponseEntity.ok(base);
    }

    @PostMapping
    @Transactional
    @Operation(summary = "Add a new event", description = "Add a new event", 
        tags = { "Events" }, 
        responses = {
            @ApiResponse(description = "Create", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EventsDto.class))),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
        )
    public ResponseEntity<ResponseBase<EventsDto>> save(@RequestBody EventsDto dto) {
        final var reponse = this.eventsServices.save(dto);
        final var base = ResponseBase.of(reponse);
        return ResponseEntity.ok(base);
    }

}
