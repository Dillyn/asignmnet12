package com.cput.lakey.repositories.staff;

import com.cput.lakey.domain.staff.EnduranceTrainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnduranceTrainerRepository extends JpaRepository<EnduranceTrainer, Integer> {
}
