package com.cput.lakey.services.session.impli;

import com.cput.lakey.domain.session.Session;
import com.cput.lakey.repositories.session.SessionRepository;
import com.cput.lakey.services.session.SessionServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionServicesImpli implements SessionServices {

    private SessionRepository sessionRepository;
    private static SessionServices sessionService = null;

    private SessionServicesImpli() {

    }

    public SessionServices getSessionService() {
        if (sessionService == null) sessionService = new SessionServicesImpli();
        return sessionService;
    }

    @Override
    public Session create(Session d) {
        return this.sessionRepository.save(d);
    }

    @Override
    public Session read(Integer strengthId) {
        Optional<Session> optGender = this.sessionRepository.findById(strengthId);
        return optGender.orElse(null);    }

    @Override
    public Session update(Session strength) {
        return this.sessionRepository.save(strength);
    }

    @Override
    public void delete(Integer strengthId) {
        this.sessionRepository.deleteById(strengthId);
    }

    @Override
    public List<Session> getAll() { return this.sessionRepository.findAll();
    }
}
