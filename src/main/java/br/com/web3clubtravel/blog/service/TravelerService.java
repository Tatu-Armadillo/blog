package br.com.web3clubtravel.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.web3clubtravel.blog.exception.NegocioException;
import br.com.web3clubtravel.blog.model.Traveler;
import br.com.web3clubtravel.blog.repository.TravelerRepository;

@Service
public class TravelerService {

    private final TravelerRepository travelerRepository;

    @Autowired
    public TravelerService(final TravelerRepository travelerRepository) {
        this.travelerRepository = travelerRepository;
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
