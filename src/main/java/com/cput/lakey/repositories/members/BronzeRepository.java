package com.cput.lakey.repositories.members;

import com.cput.lakey.domain.members.Bronze;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BronzeRepository extends JpaRepository<Bronze, Integer> {
}
