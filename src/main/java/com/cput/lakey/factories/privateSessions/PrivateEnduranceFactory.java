package com.cput.lakey.factories.privateSessions;

import com.cput.lakey.domain.privateSession.PrivateEndurance;
import com.cput.lakey.util.Helper;

import java.util.Date;

public class PrivateEnduranceFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(PrivateEnduranceFactory.class);

    public static PrivateEndurance getPrivateEndurance(Integer id,Date date, String type) {
        return new PrivateEndurance.Builder()
                .id(id)
                .date(date)
                .type(type)
                .build();
    }
}

