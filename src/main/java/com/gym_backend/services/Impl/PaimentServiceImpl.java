package com.gym_backend.services.Impl;

import com.gym_backend.models.Membre;
import com.gym_backend.models.Paiements;
import com.gym_backend.repository.MembreRepository;
import com.gym_backend.repository.PaimentsRepository;
import com.gym_backend.services.PaimentService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PaimentServiceImpl implements PaimentService {

    private final PaimentsRepository paimentsRepository;
    private final MembreRepository membreRepository;

    public PaimentServiceImpl(PaimentsRepository paimentsRepository, MembreRepository membreRepository) {
        this.paimentsRepository = paimentsRepository;
        this.membreRepository = membreRepository;
    }

    @Override
    public Optional<List<Paiements>> findByIdMembre(Long id) {

        //return paimentsRepository.findByIdMembre(id);
        return null;
    }

    @Override
    public List<Paiements> findAll() {
        return paimentsRepository.findAll();
    }



}
