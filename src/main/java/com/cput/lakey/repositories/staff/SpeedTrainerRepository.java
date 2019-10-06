package com.cput.lakey.repositories.staff;

import com.cput.lakey.domain.staff.SpeedTrainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeedTrainerRepository extends JpaRepository<SpeedTrainer, Integer> {
}
