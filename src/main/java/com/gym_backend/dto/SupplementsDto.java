package com.gym_backend.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SupplementsDto {
    private String nom;
    private String marque;
    private String type;
    private int quantity;
    private Date dateAjout;
    private Date dateVente;
    private String etat;
    private Double prixAchat;
    private Double prixVente;
}
