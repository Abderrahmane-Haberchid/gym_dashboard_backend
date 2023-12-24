package com.gym_backend.repository;

import com.gym_backend.models.Membre;
import com.gym_backend.models.Paiements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Date;
import java.util.List;

public interface PaimentsRepository extends JpaRepository<Paiements, Long> {
    @Query(value = "SELECT m FROM Membre m JOIN m.paiementsSet WHERE date_expiration < ?1")
    List<Membre> findExpiredMembre(Date date);
}
