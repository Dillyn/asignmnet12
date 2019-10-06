package com.cput.lakey.services.classes;

import com.cput.lakey.domain.classes.Endurance;
import com.cput.lakey.services.IServices;

import java.util.List;

public interface EnduranceService extends IServices<Endurance, Integer> {
    List<Endurance> getAll();
}
