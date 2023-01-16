package br.com.web3clubtravel.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.web3clubtravel.blog.dto.TravelerDto;
import br.com.web3clubtravel.blog.model.Traveler;
import br.com.web3clubtravel.blog.repository.TravelerRepository;

@Service
public class TravelerService {

    private final TravelerRepository travelerRepository;

    @Autowired
    public TravelerService(final TravelerRepository travelerRepository) {
        this.travelerRepository = travelerRepository;
    }

    public TravelerDto save(final TravelerDto dto) {
        var traveler = new Traveler(dto.getName(), dto.getPhone(), dto.getEmail());
        var response = this.travelerRepository.save(traveler);
        return TravelerDto.of(response);
    }

    public TravelerDto getKingTraveler() {
        var traveler = this.travelerRepository.findById(1L)
                .orElse(new Traveler("Club Travel", "4002-8922", "ehFunkDoJapones.@QueVaiDarPS2.com"));
        return TravelerDto.of(traveler);
    }

}
