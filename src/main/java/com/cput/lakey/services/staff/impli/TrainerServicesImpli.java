package com.cput.lakey.services.staff.impli;

import com.cput.lakey.domain.staff.Trainer;
import com.cput.lakey.repositories.staff.TrainerRepository;
import com.cput.lakey.services.staff.TrainerServices;

import java.util.List;
import java.util.Optional;

public class TrainerServicesImpli implements TrainerServices {

    private TrainerRepository trainerRepository;
    private static TrainerServices trainerService = null;

    private TrainerServicesImpli() {

    }

    public TrainerServices getTrainerService() {
        if (trainerService == null) trainerService = new TrainerServicesImpli();
        return trainerService;
    }

    @Override
    public Trainer create(Trainer d) {
        return this.trainerRepository.save(d);
    }

    @Override
    public Trainer read(Integer trainerId) {
        Optional<Trainer> optGender = this.trainerRepository.findById(trainerId);
        return optGender.orElse(null);    }

    @Override
    public Trainer update(Trainer trainer) {
        return this.trainerRepository.save(trainer);
    }

    @Override
    public void delete(Integer trainerId) {
        this.trainerRepository.deleteById(trainerId);
    }

    @Override
    public List<Trainer> getAll() { return this.trainerRepository.findAll();
    }
}
