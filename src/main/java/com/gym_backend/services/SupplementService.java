package com.gym_backend.services;

import com.gym_backend.dto.SupplementsDto;
import com.gym_backend.models.Supplements;

import java.util.List;

public interface SupplementService {
     List<Supplements> findByType(String type);
     boolean addSale(SupplementsDto supplementsDto);
     boolean addProduct(SupplementsDto supplementsDto);
}
