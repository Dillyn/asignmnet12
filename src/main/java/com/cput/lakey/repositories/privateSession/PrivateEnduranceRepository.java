package com.cput.lakey.repositories.privateSession;

import com.cput.lakey.domain.privateSession.PrivateEndurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivateEnduranceRepository extends JpaRepository<PrivateEndurance, Integer> {
}
