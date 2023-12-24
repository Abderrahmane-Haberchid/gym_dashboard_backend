package com.gym_backend.services;

import com.gym_backend.models.Membre;
import com.gym_backend.models.Paiements;

import java.util.List;
import java.util.Optional;

public interface PaimentService {
    Optional<List<Paiements>> findByIdMembre(Long id);
    List<Paiements> findAll();
}
