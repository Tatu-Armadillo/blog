package br.com.web3clubtravel.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.web3clubtravel.blog.dto.DestinationsDto;
import br.com.web3clubtravel.blog.exception.NegocioException;
import br.com.web3clubtravel.blog.model.Destinations;
import br.com.web3clubtravel.blog.repository.DestinationsRepository;

@Service
public class DestinationService {

    private final DestinationsRepository destinationsRepository;
    private final CityService cityService;
    private final ReferenceService referenceService;

    @Autowired
    public DestinationService(
            final DestinationsRepository destinationsRepository,
            final CityService cityService,
            final ReferenceService referenceService) {
        this.destinationsRepository = destinationsRepository;
        this.cityService = cityService;
        this.referenceService = referenceService;
    }

    public Destinations findById(Long idDestination) {
        return this.destinationsRepository.findById(idDestination).orElseThrow(() -> new NegocioException("Destination not found"));
    }

    public Page<DestinationsDto> listDestinationsWithFilter(Pageable pageable, String filter) {
        var valor = this.destinationsRepository.findByNameCity(pageable, filter).map(DestinationsDto::of);
        return valor;
    }

    public Destinations save(final DestinationsDto dto) {
        final var city = this.cityService.getCity(dto.getNameCity());
        final var destination = new Destinations(dto.getTitle(), city);
        final var data = this.destinationsRepository.save(destination);

        if (dto.getReferences() != null && !dto.getReferences().isEmpty()) {
            this.referenceService.save(dto.getReferences(), data);
        }

        final var response = this.findById(data.getIdDestinations());
        return response;
    }

}
