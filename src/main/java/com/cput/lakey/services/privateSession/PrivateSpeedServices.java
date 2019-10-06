package com.cput.lakey.services.privateSession;

import com.cput.lakey.domain.privateSession.PrivateSpeed;
import com.cput.lakey.services.IServices;

import java.util.List;

public interface PrivateSpeedServices extends IServices<PrivateSpeed, Integer> {
    List<PrivateSpeed> getAll();
}
