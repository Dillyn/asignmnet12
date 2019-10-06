package com.cput.lakey.services.privateSession;

import com.cput.lakey.domain.privateSession.PrivateSession;
import com.cput.lakey.services.IServices;

import java.util.List;

public interface PrivateSessionServices extends IServices<PrivateSession, Integer> {
    List<PrivateSession> getAll();
}
