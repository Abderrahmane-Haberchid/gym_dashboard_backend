package com.gym_backend.api;


import com.gym_backend.models.Membre;
import com.gym_backend.models.Paiements;
import com.gym_backend.repository.MembreRepository;
import com.gym_backend.repository.PaimentsRepository;
import com.gym_backend.services.PaimentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/payments")
public class PaimentController {

    private final PaimentService paimentService;
    private final MembreRepository membreRepository;
    private final PaimentsRepository paimentsRepository;

    public PaimentController(PaimentService paimentService, MembreRepository membreRepository, PaimentsRepository paimentsRepository) {
        this.paimentService = paimentService;
        this.membreRepository = membreRepository;
        this.paimentsRepository = paimentsRepository;
    }

    @GetMapping("all/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity findByIdMembre(@PathVariable Long id){
        if(paimentService.findByIdMembre(id).isEmpty()){
            return new ResponseEntity("nok", HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<Paiements> afficherTout(){
        return paimentService.findAll();
    }

   /* @Scheduled(fixedDelay = 86400000)
    public boolean expiredMembre() {

        List<Membre> membres = paimentsRepository.findExpiredMembre(new Date());
        membres.forEach(membre -> membre.setStatut("Unpaid"));
        for (Membre membre: membres){
            membreRepository.save(membre);
        }
        return true;
    }*/

}
