package com.cput.lakey.services.privateSession.Impli;

import com.cput.lakey.domain.privateSession.PrivateStrength;
import com.cput.lakey.repositories.privateSession.PrivateStrengthRepository;
import com.cput.lakey.services.privateSession.PrivateStrengthServices;

import java.util.List;
import java.util.Optional;

public class PrivateStrengthServicesImpli implements PrivateStrengthServices {

    private PrivateStrengthRepository sessionRepository;
    private static PrivateStrengthServices sessionService = null;

    private PrivateStrengthServicesImpli() {
    }

    public PrivateStrengthServices getPrivateSessionService() {
        if (sessionService == null) sessionService = new PrivateStrengthServicesImpli();
        return sessionService;
    }

    @Override
    public PrivateStrength create(PrivateStrength d) {
        return this.sessionRepository.save(d);
    }

    @Override
    public PrivateStrength read(Integer strengthId) {
        Optional<PrivateStrength> optGender = this.sessionRepository.findById(strengthId);
        return optGender.orElse(null);    }

    @Override
    public PrivateStrength update(PrivateStrength strength) {
        return this.sessionRepository.save(strength);
    }

    @Override
    public void delete(Integer strengthId) {
        this.sessionRepository.deleteById(strengthId);
    }

    @Override
    public List<PrivateStrength> getAll() { return this.sessionRepository.findAll();
    }
}