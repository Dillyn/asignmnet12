package com.cput.lakey.services.staff.impli;

import com.cput.lakey.domain.staff.StrengthTrainer;
import com.cput.lakey.repositories.staff.StrengthTrainerRepository;
import com.cput.lakey.services.staff.StrengthTrainerServices;

import java.util.List;
import java.util.Optional;

public class StrengthTrainerServicesImpli implements StrengthTrainerServices {

    private StrengthTrainerRepository trainerRepository;
    private static StrengthTrainerServices trainerService = null;

    private StrengthTrainerServicesImpli() {
    }

    public StrengthTrainerServices getTrainerService() {
        if (trainerService == null) trainerService = new StrengthTrainerServicesImpli();
        return trainerService;
    }

    @Override
    public StrengthTrainer create(StrengthTrainer d) {
        return this.trainerRepository.save(d);
    }

    @Override
    public StrengthTrainer read(Integer trainerId) {
        Optional<StrengthTrainer> optGender = this.trainerRepository.findById(trainerId);
        return optGender.orElse(null);    }

    @Override
    public StrengthTrainer update(StrengthTrainer trainer) {
        return this.trainerRepository.save(trainer);
    }

    @Override
    public void delete(Integer trainerId) {
        this.trainerRepository.deleteById(trainerId);
    }

    @Override
    public List<StrengthTrainer> getAll() { return this.trainerRepository.findAll();
    }
}
