package com.cput.lakey.services.staff.impli;

import com.cput.lakey.domain.staff.EnduranceTrainer;
import com.cput.lakey.repositories.staff.EnduranceTrainerRepository;
import com.cput.lakey.services.staff.EnduranceTrainerServices;

import java.util.List;
import java.util.Optional;

public class EnduranceTrainerServicesImpli implements EnduranceTrainerServices {

    private EnduranceTrainerRepository trainerRepository;
    private static EnduranceTrainerServices trainerService = null;

    private EnduranceTrainerServicesImpli() {
    }

    public EnduranceTrainerServices getTrainerService() {
        if (trainerService == null) trainerService = new EnduranceTrainerServicesImpli();
        return trainerService;
    }

    @Override
    public EnduranceTrainer create(EnduranceTrainer d) {
        return this.trainerRepository.save(d);
    }

    @Override
    public EnduranceTrainer read(Integer trainerId) {
        Optional<EnduranceTrainer> optGender = this.trainerRepository.findById(trainerId);
        return optGender.orElse(null);    }

    @Override
    public EnduranceTrainer update(EnduranceTrainer trainer) {
        return this.trainerRepository.save(trainer);
    }

    @Override
    public void delete(Integer trainerId) {
        this.trainerRepository.deleteById(trainerId);
    }

    @Override
    public List<EnduranceTrainer> getAll() { return this.trainerRepository.findAll();
    }
}