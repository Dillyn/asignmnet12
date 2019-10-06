package com.cput.lakey.repositories.members;

import com.cput.lakey.domain.members.Silver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SilverRepository extends JpaRepository<Silver, Integer> {
}
