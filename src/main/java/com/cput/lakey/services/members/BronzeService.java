package com.cput.lakey.services.members;

import com.cput.lakey.domain.members.Bronze;
import com.cput.lakey.services.IServices;

import java.util.List;

public interface BronzeService extends IServices<Bronze, Integer> {
    List<Bronze> getAll();
}
