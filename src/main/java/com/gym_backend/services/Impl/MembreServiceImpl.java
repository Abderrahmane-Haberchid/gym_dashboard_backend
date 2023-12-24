package com.gym_backend.services.Impl;
import com.gym_backend.dto.MembreDto;
import com.gym_backend.dto.PaimentDto;
import com.gym_backend.models.Membre;
import com.gym_backend.models.Paiements;
import com.gym_backend.repository.MembreRepository;
import com.gym_backend.repository.PaimentsRepository;
import com.gym_backend.services.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class MembreServiceImpl implements MembreService {

    private final MembreRepository membreRepository;
    private final PaimentsRepository paimentsRepository;
    @Autowired
    public MembreServiceImpl(MembreRepository membreRepository, PaimentsRepository paimentsRepository) {
        this.membreRepository = membreRepository;
        this.paimentsRepository = paimentsRepository;
    }


    @Override
    public Optional<List<Membre>> findAll() {
        return Optional.of(membreRepository.findAll());
    }

    @Override
    public Boolean addMembre(MembreDto membreDto) {
            Membre membre = new Membre();

            membre.setNom(membreDto.getNom());
            membre.setPrenom(membreDto.getPrenom());
            membre.setTelephone(membreDto.getTelephone());
            membre.setEmail(membreDto.getEmail());
            membre.setAdresse(membreDto.getAdresse());
            membre.setAge(membreDto.getAge());
            membre.setDate_inscription(new Date());
            membre.setDate_update(new Date());
            membre.setState("Actif");
            membre.setStatut("Bundled");
            Membre result = membreRepository.save(membre);
        if (result.equals(membre)) {
            return true;
        }
        else return false;
    }

    @Override
    public Boolean updateMembre(MembreDto membredto, Long id) {
        //Membre membre = new Membre();
          Membre membre = membreRepository.findById(id).get();

        if (Objects.equals(membre.getId_membre(), id)) {
            membre.setNom(membredto.getNom());
            membre.setPrenom(membredto.getPrenom());
            membre.setAge(membredto.getAge());
            membre.setEmail(membredto.getEmail());
            membre.setAdresse(membredto.getAdresse());
            membre.setTelephone(membredto.getTelephone());
            membre.setDate_update(new Date());

            membreRepository.save(membre);
            return true;
        }
        else return false;
    }

    @Override
    public Optional<List<Membre>> findByName(String name) {
        return membreRepository.findByNom(name);
    }

    @Override
    public Optional<List<Membre>> findByStatut(String statut) {
        return membreRepository.findByStatut(statut);
    }

    @Override
    public Optional<Membre> findByEmail(String email) {
        return membreRepository.findByEmail(email);
    }

    @Override
    public Optional<Membre> findById_membre(Long id) {

        return membreRepository.findById(id);
    }

    @Override
    public boolean addPayment(PaimentDto paimentDto, Long id) {
        Paiements paiements = new Paiements();
        Membre membre = membreRepository.findById(id).get();

        int daysToAdd = 0;
        String paymentType = paimentDto.getType_paiement();

        if (paymentType.equals("Mensuel")) {
            daysToAdd = 30;
        }
        if (paymentType.equals("Par jour")) {
            daysToAdd = 1;
        }
        if (paymentType.equals("Par 3mois")) {
            daysToAdd = 90;
        }
        if (paymentType.equals("Par 6mois")) {
            daysToAdd = 180;
        }
        if (paymentType.equals("Annuel")) {
            daysToAdd = 360;
        }

        Calendar c= Calendar.getInstance();
        c.add(Calendar.DATE, daysToAdd);
        Date date = c.getTime();

        paiements.setType_paiement(paimentDto.getType_paiement());
        paiements.setDate_paiement(new Date());
        paiements.setDate_expiration(date);
        paiements.setPrix(paimentDto.getPrix());
        paiements.setType_abonnement(paimentDto.getType_abonnement());

        membre.setDate_update(new Date());
        membre.setStatut("Paid");
        membre.getPaiementsSet().add(paiements);
        membreRepository.save(membre);
        paimentsRepository.save(paiements);

        return true;
    }

}
