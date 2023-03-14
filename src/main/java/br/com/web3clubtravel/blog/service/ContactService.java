package br.com.web3clubtravel.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.web3clubtravel.blog.dto.ContactDto;
import br.com.web3clubtravel.blog.exception.NegocioException;
import br.com.web3clubtravel.blog.model.Contact;
import br.com.web3clubtravel.blog.repository.ContactRepository;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact save(final ContactDto dto) {
        final var contact = new Contact(dto.getName(), dto.getPhone(), dto.getEmail());
        var response = this.contactRepository.save(contact);
        return response;
    }

    public Contact getContact(final String name) {
        return this.contactRepository.findContactByName(name)
                .orElseThrow(() -> new NegocioException("Contact not found"));
    }

}
