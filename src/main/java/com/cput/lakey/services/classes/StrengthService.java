package com.cput.lakey.services.classes;

import com.cput.lakey.domain.classes.Strength;
import com.cput.lakey.services.IServices;

import java.util.List;

public interface StrengthService extends IServices<Strength, Integer> {
    List<Strength> getAll();
}
