package com.cput.lakey.services.privateSession;

import com.cput.lakey.domain.privateSession.PrivateEndurance;
import com.cput.lakey.services.IServices;

import java.util.List;

public interface PrivateEnduranceServices extends IServices<PrivateEndurance, Integer> {
    List<PrivateEndurance> getAll();
}
