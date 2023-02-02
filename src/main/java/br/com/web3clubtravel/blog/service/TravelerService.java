package br.com.web3clubtravel.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.web3clubtravel.blog.dto.ContactDto;
import br.com.web3clubtravel.blog.dto.TravelerDto;
import br.com.web3clubtravel.blog.exception.NegocioException;
import br.com.web3clubtravel.blog.model.Traveler;
import br.com.web3clubtravel.blog.model.User;
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

    public TravelerDto save(final TravelerDto dto) {
        final var contactDto = new ContactDto(dto.getName(), dto.getPhone(), dto.getEmail());
        final var contact = this.contactService.save(contactDto);

        final var userDto = new User(dto.getEmail(), dto.getPassword());
        final var user = this.userService.save(userDto);

        final var traveler = new Traveler(contact, user);
        final var response = this.travelerRepository.save(traveler);
        return TravelerDto.of(response);
    }

    public Traveler getTraveler(String username) {
        final var traveler = this.travelerRepository.getTravelerByUserName(username)
                .orElseThrow(() -> new NegocioException("Viagente não encontrado"));
        return traveler;
    }

    // TODO metodo auxiliar para preencher as noticias
    public Traveler getKingTraveler() {
        final var traveler = this.travelerRepository.findById(1L)
                .orElse(new Traveler());
        return traveler;
    }

}
