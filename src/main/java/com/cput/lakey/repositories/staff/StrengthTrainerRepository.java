package com.cput.lakey.repositories.staff;

import com.cput.lakey.domain.staff.StrengthTrainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StrengthTrainerRepository extends JpaRepository<StrengthTrainer, Integer> {
}
