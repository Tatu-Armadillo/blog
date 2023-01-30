package br.com.web3clubtravel.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.web3clubtravel.blog.dto.TravelerDto;
import br.com.web3clubtravel.blog.exception.NegocioException;
import br.com.web3clubtravel.blog.model.Traveler;
import br.com.web3clubtravel.blog.model.User;
import br.com.web3clubtravel.blog.repository.TravelerRepository;

@Service
public class TravelerService {

    private final TravelerRepository travelerRepository;

    @Autowired
    public TravelerService(final TravelerRepository travelerRepository) {
        this.travelerRepository = travelerRepository;
    }

    public TravelerDto save(final TravelerDto dto) {
        final var traveler = new Traveler(dto.getName(), dto.getPhone(), dto.getEmail());

        traveler.setUser(createUserDto(dto));

        this.travelerRepository.save(traveler);

        final var response = this.getTraveler(traveler.getUser().getUsername());

        return TravelerDto.of(response);
    }

    // TODO metodo a ser criado futuramente em service de users
    public User createUserDto(TravelerDto travelerDto) {
        if (travelerDto.getUserDto() != null
                && travelerDto.getUserDto().getUsername() != null
                && travelerDto.getUserDto().getPassword() != null
                && !travelerDto.getUserDto().getUsername().trim().isEmpty()
                && !travelerDto.getUserDto().getPassword().trim().isEmpty()) {
            final var userDto = travelerDto.getUserDto();
            final var user = new User(userDto.getUsername(), userDto.getPassword());
            return user;
        }
        throw new NegocioException("Null User");
    }

    public Traveler getTraveler(String username) {
        final var traveler = this.travelerRepository.getTravelerByUserName(username)
                .orElseThrow(() -> new NegocioException("Viagente não encontrado"));
        return traveler;
    }

    // TODO metodo auxiliar para preencher as noticias
    public TravelerDto getKingTravelerDto() {
        final var traveler = this.travelerRepository.findById(1L)
                .orElse(new Traveler("Club Travel", "4002-8922", "ehFunkDoJapones.@QueVaiDarPS2.com"));
        return TravelerDto.of(traveler);
    }

    // TODO metodo auxiliar para preencher as noticias
    public Traveler getKingTraveler() {
        final var traveler = this.travelerRepository.findById(1L)
                .orElse(new Traveler("Club Travel", "4002-8922", "ehFunkDoJapones.@QueVaiDarPS2.com"));
        return traveler;
    }

}
