package com.cput.lakey.services.privateSession.Impli;

import com.cput.lakey.domain.privateSession.PrivateSession;
import com.cput.lakey.repositories.privateSession.PrivateSessionRepository;
import com.cput.lakey.services.privateSession.PrivateSessionServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrivateSessionServicesImpli implements PrivateSessionServices {

    private PrivateSessionRepository sessionRepository;
    private static PrivateSessionServices sessionService = null;

    private PrivateSessionServicesImpli() {
    }

    public PrivateSessionServices getPrivateSessionService() {
        if (sessionService == null) sessionService = new PrivateSessionServicesImpli();
        return sessionService;
    }

    @Override
    public PrivateSession create(PrivateSession d) {
        return this.sessionRepository.save(d);
    }

    @Override
    public PrivateSession read(Integer strengthId) {
        Optional<PrivateSession> optGender = this.sessionRepository.findById(strengthId);
        return optGender.orElse(null);    }

    @Override
    public PrivateSession update(PrivateSession strength) {
        return this.sessionRepository.save(strength);
    }

    @Override
    public void delete(Integer strengthId) {
        this.sessionRepository.deleteById(strengthId);
    }

    @Override
    public List<PrivateSession> getAll() { return this.sessionRepository.findAll();
    }
}
