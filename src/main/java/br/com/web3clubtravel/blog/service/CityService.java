package br.com.web3clubtravel.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.web3clubtravel.blog.exception.NegocioException;
import br.com.web3clubtravel.blog.model.City;
import br.com.web3clubtravel.blog.record.CityRecord;
import br.com.web3clubtravel.blog.repository.CityRepository;

@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(final CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City getCity(final String city) {
        return this.cityRepository.findByNameCity(city)
                .orElseThrow(() -> new NegocioException("City not found"));
    }

    public Page<CityRecord> getCitiesDto(final Pageable pageable, final String name) {
        return this.cityRepository.findCitiesPagination(pageable, name).map(CityRecord::of);
    }

}
