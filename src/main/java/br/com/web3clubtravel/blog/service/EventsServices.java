package br.com.web3clubtravel.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.web3clubtravel.blog.dto.EventsDto;
import br.com.web3clubtravel.blog.model.Events;
import br.com.web3clubtravel.blog.repository.EventsRepository;

@Service
public class EventsServices {

    private final EventsRepository eventsRepository;
    private final CityService cityService;

    @Autowired
    public EventsServices(
            final EventsRepository eventsRepository,
            final CityService cityService) {
        this.eventsRepository = eventsRepository;
        this.cityService = cityService;
    }

    public Page<EventsDto> ListEvents(Pageable pageable) {
        return this.eventsRepository.findAll(pageable).map(EventsDto::of);
    }

    public EventsDto save(final EventsDto dto) {
        final var city = this.cityService.getCity(dto.getNameCity());
        final var event = new Events(
                dto.getStarDate(),
                dto.getEndDate(),
                dto.getDescription(),
                city);
        final var response = this.eventsRepository.save(event);
        return EventsDto.of(response);
    }

}
