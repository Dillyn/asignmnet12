package com.cput.lakey.repositories.staff;

import com.cput.lakey.domain.staff.CompleteTrainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompleteTrainerRepository extends JpaRepository<CompleteTrainer, Integer> {
}
