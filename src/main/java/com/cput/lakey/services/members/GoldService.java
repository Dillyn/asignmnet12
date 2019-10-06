package com.cput.lakey.services.members;

import com.cput.lakey.domain.members.Gold;
import com.cput.lakey.services.IServices;

import java.util.List;

public interface GoldService extends IServices<Gold, Integer> {
    List<Gold> getAll();
}
