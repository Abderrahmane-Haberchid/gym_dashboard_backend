package com.gym_backend.repository;

import com.gym_backend.models.Supplements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SupplementsRepository extends JpaRepository<Supplements, Long> {
        List<Supplements> findByType(String type);
        List<Supplements> findByTypeAndMarque(String type, String marque);

}
