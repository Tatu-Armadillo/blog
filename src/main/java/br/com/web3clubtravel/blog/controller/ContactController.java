package br.com.web3clubtravel.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.web3clubtravel.blog.dto.ContactDto;
import br.com.web3clubtravel.blog.response.ResponseBase;
import br.com.web3clubtravel.blog.service.ContactService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/contact")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ResponseBase<ContactDto>> save(
            @RequestBody ContactDto dto) {
        final var contact = this.contactService.save(dto);
        final var response = new ContactDto(contact.getName(), contact.getPhone(), contact.getEmail());
        final var base = ResponseBase.of(response);
        return ResponseEntity.ok(base);
    }

}
