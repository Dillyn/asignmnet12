package com.cput.lakey.services.privateSession;

import com.cput.lakey.domain.privateSession.PrivateStrength;
import com.cput.lakey.services.IServices;

import java.util.List;

public interface PrivateStrengthServices extends IServices<PrivateStrength, Integer> {
    List<PrivateStrength> getAll();
}
