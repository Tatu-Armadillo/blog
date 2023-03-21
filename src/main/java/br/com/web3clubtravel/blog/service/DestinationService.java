package br.com.web3clubtravel.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.web3clubtravel.blog.dto.DestinationsDto;
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

    public Page<DestinationsDto> listDestinationsWithFilter(Pageable pageable, String filter) {
        return this.destinationsRepository.findByNameCity(pageable, filter).map(DestinationsDto::of);
    }

    public Destinations save(final DestinationsDto dto) {
        final var city = this.cityService.getCity(dto.getCity());
        final var destination = new Destinations(dto.transformAttributesInReference(), dto.getImageLink(), city);
        this.destinationsRepository.save(destination);
        return destination;
    }

}
