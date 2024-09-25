package com.example.metrics.entity;

import jakarta.persistence.*;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@NoArgsConstructor
@Builder
@Data
@Table(name = "client")


public class clientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id", nullable = false)
    private long id;

    public clientEntity(String nom_client, String adresse_client) {
        this.nom_client = nom_client;
        this.adresse_client = adresse_client;
    }

    private String nom_client;
    private String adresse_client;

    public clientEntity(long id, String nom_client, String adresse_client) {
        this.id = id;
        this.nom_client = nom_client;
        this.adresse_client = adresse_client;
    }



}