package br.com.web3clubtravel.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.web3clubtravel.blog.model.Destinations;
import br.com.web3clubtravel.blog.repository.DestinationsRepository;

@Service
public class DestinationService {

    private final DestinationsRepository destinationsRepository;

    @Autowired
    public DestinationService(final DestinationsRepository destinationsRepository) {
        this.destinationsRepository = destinationsRepository;
    }

    public Destinations findByNameCity(final String city) {
        return this.destinationsRepository.findByNameCity(city);
    }

}
