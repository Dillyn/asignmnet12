package com.cput.lakey.repositories.studio;

import com.cput.lakey.domain.studio.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudioRepository extends JpaRepository<Studio, Integer> {
}
