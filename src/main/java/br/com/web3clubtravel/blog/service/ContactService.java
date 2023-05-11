package br.com.web3clubtravel.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.web3clubtravel.blog.exception.NegocioException;
import br.com.web3clubtravel.blog.model.Contact;
import br.com.web3clubtravel.blog.record.ContactRecord;
import br.com.web3clubtravel.blog.repository.ContactRepository;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact save(final ContactRecord record) {
        // TODO criar validação de existencia do CONTATO
        final var contact = new Contact(record.name(), record.phone(), record.email());
        var response = this.contactRepository.save(contact);
        return response;
    }

    public Contact getContact(final String name) {
        return this.contactRepository.findContactByName(name)
                .orElseThrow(() -> new NegocioException("Contact not found"));
    }

}
