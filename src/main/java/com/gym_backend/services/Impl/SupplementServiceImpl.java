package com.gym_backend.services.Impl;

import com.gym_backend.dto.SupplementsDto;
import com.gym_backend.models.Supplements;
import com.gym_backend.repository.SupplementsRepository;
import com.gym_backend.services.SupplementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplementServiceImpl implements SupplementService {

    @Autowired
    private final SupplementsRepository supplementsRepository;

    public SupplementServiceImpl(SupplementsRepository supplementsRepository) {
        this.supplementsRepository = supplementsRepository;
    }

    @Override
    public List<Supplements> findByType(String type) {
        return supplementsRepository.findByType(type);
    }

    @Override
    public boolean addSale(SupplementsDto supplementsDto) {
       Supplements supplements = supplementsRepository.findByTypeAndMarque(supplementsDto.getType(), supplementsDto.getMarque()).get(0);
       int qte = supplements.getQuantity() - supplementsDto.getQuantity();
        if (qte < 0) {
            return false;
        }
        else{
            supplements.setQuantity(qte);
            supplementsRepository.save(supplements);
            return true;
        }
    }

    @Override
    public boolean addProduct(SupplementsDto supplementsDto) {
        Supplements supplements = supplementsRepository.findByTypeAndMarque(supplementsDto.getType(), supplementsDto.getMarque()).get(0);
        int qte = supplements.getQuantity() + supplementsDto.getQuantity();
        supplements.setQuantity(qte);
        supplementsRepository.save(supplements);
        return true;
    }

}
