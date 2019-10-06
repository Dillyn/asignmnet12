package com.cput.lakey.repositories.classes;

import com.cput.lakey.domain.classes.Classs;
import com.cput.lakey.domain.classes.Speed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SpeedRepository extends JpaRepository<Speed, Integer> {
}
