package br.com.web3clubtravel.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.web3clubtravel.blog.dto.DestinationsDto;
import br.com.web3clubtravel.blog.exception.NegocioException;
import br.com.web3clubtravel.blog.model.Destinations;
import br.com.web3clubtravel.blog.repository.DestinationsRepository;

@Service
public class DestinationService {

    private final DestinationsRepository destinationsRepository;
    private final CityService cityService;

    @Autowired
    public DestinationService(
            final DestinationsRepository destinationsRepository,
            final CityService cityService) {
        this.destinationsRepository = destinationsRepository;
        this.cityService = cityService;
    }

    public Destinations findByNameCity(final String city) {
        final var destination = this.destinationsRepository.findByNameCity(city)
                .orElseThrow(() -> new NegocioException("Destino não cadastrado para esta cidade"));
        return destination;
    }

    public Destinations save(final DestinationsDto dto) {
        final var city = this.cityService.getCity(dto.getCity());
        final var destination = new Destinations(dto.transformAttributesInReference(), dto.getImageLink(), city);
        this.destinationsRepository.save(destination);
        return destination;
    }

}
