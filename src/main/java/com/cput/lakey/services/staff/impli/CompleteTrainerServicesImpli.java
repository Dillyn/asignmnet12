package com.cput.lakey.services.staff.impli;

import com.cput.lakey.domain.staff.CompleteTrainer;
import com.cput.lakey.repositories.staff.CompleteTrainerRepository;
import com.cput.lakey.services.staff.CompleteTrainerServices;

import java.util.List;
import java.util.Optional;

public class CompleteTrainerServicesImpli implements CompleteTrainerServices {


        private CompleteTrainerRepository trainerRepository;
        private static CompleteTrainerServices trainerService = null;

    private CompleteTrainerServicesImpli() {
    }

        public CompleteTrainerServices getTrainerService() {
        if (trainerService == null) trainerService = new CompleteTrainerServicesImpli();
        return trainerService;
    }

        @Override
        public CompleteTrainer create(CompleteTrainer d) {
        return this.trainerRepository.save(d);
    }

        @Override
        public CompleteTrainer read(Integer trainerId) {
            Optional<CompleteTrainer> optGender = this.trainerRepository.findById(trainerId);
            return optGender.orElse(null);    }

        @Override
        public CompleteTrainer update(CompleteTrainer trainer) {
        return this.trainerRepository.save(trainer);
    }

        @Override
        public void delete(Integer trainerId) {
        this.trainerRepository.deleteById(trainerId);
    }

        @Override
        public List<CompleteTrainer> getAll() { return this.trainerRepository.findAll();
    }
    }
