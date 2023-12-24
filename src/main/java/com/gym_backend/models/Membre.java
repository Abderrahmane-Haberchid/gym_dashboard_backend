package com.gym_backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Membre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_membre;
    private String nom;
    private String prenom;
    @Column(unique = true)
    private String email;
    private int age;
    private int telephone;
    private String adresse;
    private String statut;
    private Date date_inscription;
    private Date date_update;
    private String state;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "membre_paiement",
            joinColumns = { @JoinColumn(name = "id_membre") },
            inverseJoinColumns = { @JoinColumn(name = "id_paiement") }
    )
    Set<Paiements> paiementsSet = new HashSet<>();
}
