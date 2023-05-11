package br.com.web3clubtravel.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.web3clubtravel.blog.record.ContactRecord;
import br.com.web3clubtravel.blog.response.ResponseBase;
import br.com.web3clubtravel.blog.service.ContactService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/contact")
@Tag(name = "Contact", description = "Endpoints for Create a new contact")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    @Transactional
    @Operation(summary = "Add a new Contact", description = "Add a new Contact", tags = { "Contact" }, responses = {
            @ApiResponse(description = "Create", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ContactRecord.class))),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public ResponseEntity<ResponseBase<ContactRecord>> save(
            @Valid @RequestBody ContactRecord record) {
        final var response = this.contactService.save(record);
        final var base = ResponseBase.of(ContactRecord.of(response));
        return ResponseEntity.status(201).body(base);
    }

}
