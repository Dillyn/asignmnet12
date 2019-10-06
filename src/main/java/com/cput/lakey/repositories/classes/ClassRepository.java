package com.cput.lakey.repositories.classes;

import com.cput.lakey.domain.classes.Classs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public interface ClassRepository  extends JpaRepository<Classs, Integer> {
}
