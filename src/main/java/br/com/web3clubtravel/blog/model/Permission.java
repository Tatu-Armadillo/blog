package br.com.web3clubtravel.blog.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "permission")
public class Permission {

    @Id
    @Column(name = "id_permission")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPermission;

    @Column(name = "description")
    private String description;

    public Permission() { }

    public Permission(String description) {
        this.description = description;
    }
}
