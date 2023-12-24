package com.gym_backend.api;

import com.gym_backend.dto.SupplementsDto;
import com.gym_backend.models.Supplements;
import com.gym_backend.services.SupplementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/supplements")
@CrossOrigin(origins = "http://localhost:3000")
public class SupplementController {

    private final SupplementService supplementService;

    @Autowired
    public SupplementController(SupplementService supplementService) {
        this.supplementService = supplementService;
    }

    @GetMapping("{type}")
    public List<Supplements> afficherParType(@PathVariable String type){
         return supplementService.findByType(type);
    }

    @PostMapping("/addSale")
    public ResponseEntity<String> ajouterVente(@RequestBody SupplementsDto supplementsDto){
                if(supplementService.addSale(supplementsDto))
                    return new ResponseEntity<>(supplementsDto.toString(), HttpStatus.OK);
                else return new ResponseEntity<>("nok", HttpStatus.BAD_REQUEST);
    }
}
