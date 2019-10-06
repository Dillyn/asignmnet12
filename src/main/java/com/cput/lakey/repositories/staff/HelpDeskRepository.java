package com.cput.lakey.repositories.staff;

import com.cput.lakey.domain.staff.HelpDesk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelpDeskRepository extends JpaRepository<HelpDesk, Integer> {
}
