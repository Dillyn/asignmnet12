package com.cput.lakey.services.classes;

import com.cput.lakey.domain.classes.Speed;
import com.cput.lakey.services.IServices;

import java.util.List;

public interface SpeedService extends IServices<Speed, Integer> {
    List<Speed> getAll();
}
