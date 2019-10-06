package com.cput.lakey.repositories.classes;

import com.cput.lakey.domain.classes.Endurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnduranceRepository  extends JpaRepository<Endurance, Integer> {
}
