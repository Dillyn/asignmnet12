package com.cput.lakey.services.classes.Impli;

import com.cput.lakey.domain.classes.Speed;
import com.cput.lakey.repositories.classes.SpeedRepository;
import com.cput.lakey.services.classes.SpeedService;

import java.util.List;
import java.util.Optional;

public class SpeedServiceImpli implements SpeedService {

    private SpeedRepository classRepository;
    private static SpeedService classService = null;

    private SpeedServiceImpli() {

    }

    public SpeedService getEnduranceService() {
        if (classService == null) classService = new SpeedServiceImpli();
        return classService;
    }

    @Override
    public Speed create(Speed d) {
        return this.classRepository.save(d);
    }

    @Override
    public Speed read(Integer genderId) {
        Optional<Speed> optGender = this.classRepository.findById(genderId);
        return optGender.orElse(null);
    }

    @Override
    public Speed update(Speed gender) {
        return this.classRepository.save(gender);
    }

    @Override
    public void delete(Integer genderId) {
        this.classRepository.deleteById(genderId);
    }

    @Override
    public List<Speed> getAll() {
        return this.classRepository.findAll();
    }
}

