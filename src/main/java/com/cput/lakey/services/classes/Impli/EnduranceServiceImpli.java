package com.cput.lakey.services.classes.Impli;

import com.cput.lakey.domain.classes.Endurance;
import com.cput.lakey.repositories.classes.EnduranceRepository;
import com.cput.lakey.services.classes.EnduranceService;

import java.util.List;
import java.util.Optional;

public class EnduranceServiceImpli implements EnduranceService {

    private EnduranceRepository classRepository;
    private static EnduranceService classService = null;

    private EnduranceServiceImpli(){}


    public EnduranceService getEnduranceService() {
        if (classService == null) classService = new EnduranceServiceImpli();
        return classService;
    }

    @Override
    public Endurance create(Endurance d) {
        return this.classRepository.save(d);
    }

    @Override
    public Endurance read(Integer genderId) {
        Optional<Endurance> optGender = this.classRepository.findById(genderId);
        return optGender.orElse(null);
    }

    @Override
    public Endurance update(Endurance gender) {
        return this.classRepository.save(gender);
    }

    @Override
    public void delete(Integer genderId) {
        this.classRepository.deleteById(genderId);
    }

    @Override
    public List<Endurance> getAll() {
        return this.classRepository.findAll();
    }
}



