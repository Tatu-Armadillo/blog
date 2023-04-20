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
@Table(name = "reference")
public class Reference {

    @Id
    @Column(name = "id_reference")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReference;

    @Column(name = "key_reference")
    private String keyReference;

    @Column(name = "valor")
    private String valor;

    @Column(name = "image_link")
    private String imageLink;

    @Column(name = "image")
    private byte[] image;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "destination", foreignKey = @ForeignKey(name = "fk_destination_reference"))
    private Destinations destinations;

    public Reference() {
    }

    public Reference(Long idReference, String keyReference, String valor, String imageLink, byte[] image) {
        this.idReference = idReference;
        this.keyReference = keyReference;
        this.valor = valor;
        this.imageLink = imageLink;
        this.image = image;
    }

    public Long getIdReference() {
        return idReference;
    }

    public void setIdReference(Long idReference) {
        this.idReference = idReference;
    }

    public String getKeyReference() {
        return keyReference;
    }

    public void setKeyReference(String keyReference) {
        this.keyReference = keyReference;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

}
