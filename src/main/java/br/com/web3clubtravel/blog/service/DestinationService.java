package br.com.web3clubtravel.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.web3clubtravel.blog.exception.NotFoundException;
import br.com.web3clubtravel.blog.model.Destinations;
import br.com.web3clubtravel.blog.record.DestinationsRecord;
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
        return this.destinationsRepository.findById(idDestination)
                .orElseThrow(() -> new NotFoundException("Destination not found with id = " + idDestination));
    }

    public Page<DestinationsRecord> listDestinationsWithFilter(Pageable pageable, String filter) {
        var valor = this.destinationsRepository.findByNameCity(pageable, filter).map(DestinationsRecord::of);
        return valor;
    }

    public Destinations save(final DestinationsRecord dto) {
        final var city = this.cityService.getCity(dto.nameCity());
        final var destination = new Destinations(dto.title(), city);
        final var data = this.destinationsRepository.save(destination);

        if (dto.references() != null && !dto.references().isEmpty()) {
            this.referenceService.save(dto.references(), data);
        }

        final var response = this.findById(data.getIdDestinations());
        return response;
    }

}
