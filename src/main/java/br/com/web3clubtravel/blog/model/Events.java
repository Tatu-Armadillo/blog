package br.com.web3clubtravel.blog.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "events")
public class Events {

    @Id
    @Column(name = "id_events")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvents;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "destinations", foreignKey = @ForeignKey(name = "fk_destinations_events"))
    private Destinations destinations;

    public Events() { }

    public Events(Long idEvents, LocalDate startDate, LocalDate endDate, String description,
            Destinations destinations) {
        this.idEvents = idEvents;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.destinations = destinations;
    }

    public Long getIdEvents() {
        return idEvents;
    }

    public void setIdEvents(Long idEvents) {
        this.idEvents = idEvents;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
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

    public Destinations getDestinations() {
        return destinations;
    }

    public void setDestinations(Destinations destinations) {
        this.destinations = destinations;
    }

}
