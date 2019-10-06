package com.cput.lakey.services.session;

import com.cput.lakey.domain.session.Session;
import com.cput.lakey.services.IServices;

import java.util.List;

public interface SessionServices extends IServices<Session, Integer> {
    List<Session> getAll();
}
