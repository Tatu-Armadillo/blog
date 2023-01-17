package br.com.web3clubtravel.blog.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "region")
public class Region {

    @Id
    @Column(name = "id_region")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegion;

    @Column(name = "name")
    private String name;

    @Column(name = "uf")
    private String uf;

    public Region() { }

    public Region(String name, String uf) {
        this.name = name;
        this.uf = uf;
    }

    public Long getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Long idRegion) {
        this.idRegion = idRegion;
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

}
