package com.cput.lakey.services.classes.Impli;

import com.cput.lakey.domain.classes.Strength;
import com.cput.lakey.repositories.classes.StrengthRepository;
import com.cput.lakey.services.classes.StrengthService;

import java.util.List;
import java.util.Optional;

public class StrengthServiceImpli implements StrengthService {

    private StrengthRepository classRepository;
    private static StrengthService classService = null;

    private StrengthServiceImpli() {
    }

    public StrengthService getStrengthService() {
        if (classService == null) classService = new StrengthServiceImpli();
        return classService;
    }

    @Override
    public Strength create(Strength d) { return this.classRepository.save(d);
    }

    @Override
    public Strength read(Integer strengthId) {
        Optional<Strength> optGender = this.classRepository.findById(strengthId);
        return optGender.orElse(null);
    }

    @Override
    public Strength update(Strength strength) {
        return this.classRepository.save(strength);
    }

    @Override
    public void delete(Integer strengthId) {
        this.classRepository.deleteById(strengthId);
    }

    @Override
    public List<Strength> getAll() {
        return this.classRepository.findAll();
    }
}