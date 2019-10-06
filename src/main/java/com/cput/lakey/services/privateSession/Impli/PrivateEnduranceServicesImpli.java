package com.cput.lakey.services.privateSession.Impli;

import com.cput.lakey.domain.privateSession.PrivateEndurance;
import com.cput.lakey.repositories.privateSession.PrivateEnduranceRepository;
import com.cput.lakey.services.privateSession.PrivateEnduranceServices;

import java.util.List;
import java.util.Optional;

public class PrivateEnduranceServicesImpli implements PrivateEnduranceServices {

    private PrivateEnduranceRepository sessionRepository;
    private static PrivateEnduranceServices sessionService = null;

    private PrivateEnduranceServicesImpli() {
    }

    public PrivateEnduranceServices getPrivateSessionService() {
        if (sessionService == null) sessionService = new PrivateEnduranceServicesImpli();
        return sessionService;
    }

    @Override
    public PrivateEndurance create(PrivateEndurance d) {
        return this.sessionRepository.save(d);
    }

    @Override
    public PrivateEndurance read(Integer strengthId)    {
        Optional<PrivateEndurance> optGender = this.sessionRepository.findById(strengthId);
        return optGender.orElse(null);    }

    @Override
    public PrivateEndurance update(PrivateEndurance strength) {
        return this.sessionRepository.save(strength);
    }

    @Override
    public void delete(Integer strengthId) {
        this.sessionRepository.deleteById(strengthId);
    }

    @Override
    public List<PrivateEndurance> getAll() { return this.sessionRepository.findAll();
    }
}
