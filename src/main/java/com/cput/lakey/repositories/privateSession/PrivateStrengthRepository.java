package com.cput.lakey.repositories.privateSession;

import com.cput.lakey.domain.privateSession.PrivateStrength;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivateStrengthRepository extends JpaRepository<PrivateStrength, Integer> {
}
