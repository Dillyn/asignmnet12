package com.cput.lakey.repositories.privateSession;

import com.cput.lakey.domain.privateSession.PrivateSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivateSessionRepository extends JpaRepository<PrivateSession, Integer> {
}
