package com.cput.lakey.services.privateSession.Impli;

import com.cput.lakey.domain.privateSession.PrivateSpeed;
import com.cput.lakey.repositories.privateSession.PrivateSpeedRepository;
import com.cput.lakey.services.privateSession.PrivateSpeedServices;

import java.util.List;
import java.util.Optional;

public class PrivateSpeedServicesImpli implements PrivateSpeedServices {

    private PrivateSpeedRepository sessionRepository;
    private static PrivateSpeedServices sessionService = null;

    private PrivateSpeedServicesImpli() {

    }

    public PrivateSpeedServices getPrivateSessionService() {
        if (sessionService == null) sessionService = new PrivateSpeedServicesImpli();
        return sessionService;
    }

    @Override
    public PrivateSpeed create(PrivateSpeed d) {
        return this.sessionRepository.save(d);
    }

    @Override
    public PrivateSpeed read(Integer strengthId) {
        Optional<PrivateSpeed> optGender = this.sessionRepository.findById(strengthId);
        return optGender.orElse(null);    }

    @Override
    public PrivateSpeed update(PrivateSpeed strength) {
        return this.sessionRepository.save(strength);
    }

    @Override
    public void delete(Integer strengthId) {
        this.sessionRepository.deleteById(strengthId);
    }

    @Override
    public List<PrivateSpeed> getAll() { return this.sessionRepository.findAll();
    }
}
