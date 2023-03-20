package br.com.web3clubtravel.blog.dto;

import java.time.LocalDate;

import br.com.web3clubtravel.blog.model.Events;

public class EventsDto {

    private LocalDate starDate;
    private LocalDate endDate;
    private String description;
    private String nameCity;

    public EventsDto() { }

    public EventsDto(LocalDate starDate, LocalDate endDate, String description, String nameCity) {
        this.starDate = starDate;
        this.endDate = endDate;
        this.description = description;
        this.nameCity = nameCity;
    }

    public static EventsDto of(Events events) {
        return new EventsDto(
                events.getStartDate(),
                events.getEndDate(),
                events.getDescription(),
                events.getCity().getName());
    }

    public LocalDate getStarDate() {
        return starDate;
    }

    public void setStarDate(LocalDate starDate) {
        this.starDate = starDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

}
