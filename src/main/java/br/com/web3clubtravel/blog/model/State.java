package br.com.web3clubtravel.blog.model;

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
@Table(name = "state")
public class State {

    @Id
    @Column(name = "id_state")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idState;

    @Column(name = "uf_code")
    private String ufCode;

    @Column(name = "name")
    private String name;

    @Column(name = "uf")
    private String uf;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "region", foreignKey = @ForeignKey(name = "fk_region_state"))
    private Region region;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country", foreignKey = @ForeignKey(name = "fk_country_state"))
    private Country country;

    public State() { }

    public State(String ufCode, String name, String uf, Region region, Country country) {
        this.ufCode = ufCode;
        this.name = name;
        this.uf = uf;
        this.region = region;
        this.country = country;
    }

    public Long getIdState() {
        return idState;
    }

    public void setIdState(Long idState) {
        this.idState = idState;
    }

    public String getUfCode() {
        return ufCode;
    }

    public void setUfCode(String ufCode) {
        this.ufCode = ufCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    


}
