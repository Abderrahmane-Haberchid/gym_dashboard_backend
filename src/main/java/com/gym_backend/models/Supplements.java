package com.gym_backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Supplements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nom;
    @Column
    private String marque;
    @Column
    private String type;
    @Column
    private int quantity;
    @Column
    private Date dateAjout;
    @Column
    private Date dateVente;
    @Column
    private String etat;
    @Column
    private Double prixAchat;
    @Column
    private Double prixVente;

}
