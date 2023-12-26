package com.gym_backend.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class MembreDto {

    private Long id;
    private String nom;
    private String prenom;
    private String email;

    private int age;
    private int telephone;
    private String adresse;

    private String statut;

    private Date date_inscription;

    private Date date_update;

    private String state;
}
