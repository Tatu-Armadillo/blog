package br.com.web3clubtravel.blog.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "destinations")
public class Destinations {

    @Id
    @Column(name = "id_destinations")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDestinations;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "destinations", fetch = FetchType.LAZY)
    private List<Reference> references;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city", foreignKey = @ForeignKey(name = "fk_city_destinations"))
    private City city;

    public Destinations() { }

    public Destinations(String title, City city) {
        this.title = title;
        this.city = city;
    }

    public Long getIdDestinations() {
        return idDestinations;
    }

    public void setIdDestinations(Long idDestinations) {
        this.idDestinations = idDestinations;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Reference> getReferences() {
        return references;
    }

    public void setReferences(List<Reference> references) {
        this.references = references;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}
