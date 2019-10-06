package com.cput.lakey.repositories.staff;

import com.cput.lakey.domain.staff.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Integer> {
}
