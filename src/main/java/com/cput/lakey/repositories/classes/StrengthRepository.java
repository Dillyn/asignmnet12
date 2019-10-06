package com.cput.lakey.repositories.classes;

import com.cput.lakey.domain.classes.Strength;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StrengthRepository  extends JpaRepository<Strength, Integer> {
}
