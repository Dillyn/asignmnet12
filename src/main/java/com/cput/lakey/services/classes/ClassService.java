package com.cput.lakey.services.classes;

import com.cput.lakey.domain.classes.Classs;
import com.cput.lakey.services.IServices;

import java.util.List;

public interface ClassService extends IServices<Classs, Integer> {
    List<Classs> getAll();
}
