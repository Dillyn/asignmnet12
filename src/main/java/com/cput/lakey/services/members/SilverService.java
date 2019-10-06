package com.cput.lakey.services.members;

import com.cput.lakey.domain.members.Silver;
import com.cput.lakey.services.IServices;

import java.util.List;

public interface SilverService extends IServices<Silver, Integer> {
    List<Silver> getAll();
}
