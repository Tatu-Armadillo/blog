package br.com.web3clubtravel.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.web3clubtravel.blog.exception.NegocioException;
import br.com.web3clubtravel.blog.model.Traveler;
import br.com.web3clubtravel.blog.model.User;
import br.com.web3clubtravel.blog.record.TravelerRecord;
import br.com.web3clubtravel.blog.repository.TravelerRepository;

@Service
public class TravelerService {

    private final TravelerRepository travelerRepository;
    private final ContactService contactService;
    private final UserService userService;

    @Autowired
    public TravelerService(
            final TravelerRepository travelerRepository,
            final ContactService contactService,
            final UserService userService) {
        this.travelerRepository = travelerRepository;
        this.contactService = contactService;
        this.userService = userService;
    }

    public Traveler save(final TravelerRecord dto) {
        final var contact = this.contactService.save(dto.contact());

        final var userDto = new User(contact.getEmail(), dto.password());
        final var user = this.userService.save(userDto);

        final var traveler = new Traveler(contact, user);
        final var response = this.travelerRepository.save(traveler);
        return response;
    }

    public Traveler getTraveler(String username) {
        final var traveler = this.travelerRepository.getTravelerByUserName(username)
                .orElseThrow(() -> new NegocioException("Traveler not found"));
        return traveler;
    }

    // TODO metodo auxiliar para preencher as noticias
    public Traveler getKingTraveler() {
        final var traveler = this.travelerRepository.findById(1L)
                .orElse(new Traveler());
        return traveler;
    }

}
