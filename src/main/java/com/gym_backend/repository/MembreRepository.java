package com.gym_backend.repository;

import com.gym_backend.models.Membre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface MembreRepository extends JpaRepository<Membre, Long> {

    Optional<List<Membre>> findByNom(String name);

    Optional<List<Membre>> findByStatut(String statut);
    Optional<Membre> findByEmail(String email);
    Optional<Membre> findById(Long id);
    boolean existsByEmail(String email);


}
