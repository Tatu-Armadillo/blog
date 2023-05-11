package br.com.web3clubtravel.blog.record;

import br.com.web3clubtravel.blog.model.City;

public record CityRecord(
        Long idCity,
        String name) {

    public static CityRecord of(City city) {
        return new CityRecord(
                city.getIdCity(),
                city.getName());
    }

}
