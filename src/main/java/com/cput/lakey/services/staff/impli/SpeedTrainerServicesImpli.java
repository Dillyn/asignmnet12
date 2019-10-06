package com.cput.lakey.services.staff.impli;


import com.cput.lakey.domain.staff.SpeedTrainer;
import com.cput.lakey.repositories.staff.SpeedTrainerRepository;
import com.cput.lakey.services.staff.SpeedTrainerServices;

import java.util.List;
import java.util.Optional;

public class SpeedTrainerServicesImpli implements SpeedTrainerServices {

    private SpeedTrainerRepository trainerRepository;
    private static SpeedTrainerServices trainerService = null;

    private SpeedTrainerServicesImpli() {
    }

    public SpeedTrainerServices getTrainerService() {
        if (trainerService == null) trainerService = new SpeedTrainerServicesImpli();
        return trainerService;
    }

    @Override
    public SpeedTrainer create(SpeedTrainer d) {
        return this.trainerRepository.save(d);
    }

    @Override
    public SpeedTrainer read(Integer trainerId) {
        Optional<SpeedTrainer> optGender = this.trainerRepository.findById(trainerId);
        return optGender.orElse(null);    }

    @Override
    public SpeedTrainer update(SpeedTrainer trainer) {
        return this.trainerRepository.save(trainer);
    }

    @Override
    public void delete(Integer trainerId) {
        this.trainerRepository.deleteById(trainerId);
    }

    @Override
    public List<SpeedTrainer> getAll() { return this.trainerRepository.findAll();
    }
}
