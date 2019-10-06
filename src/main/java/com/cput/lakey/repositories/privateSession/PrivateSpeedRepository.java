package com.cput.lakey.repositories.privateSession;

import com.cput.lakey.domain.privateSession.PrivateSpeed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivateSpeedRepository extends JpaRepository<PrivateSpeed, Integer> {
}
