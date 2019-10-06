package com.cput.lakey.factories.privateSessions;

import com.cput.lakey.domain.privateSession.PrivateStrength;
import com.cput.lakey.util.Helper;

import java.util.Date;

public class PrivateStrengthFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(PrivateStrengthFactory.class);

    public static PrivateStrength getPrivateStrength(Integer id,Date date, String type) {
        return new PrivateStrength.Builder()
                .id(id)
                .date(date)
                .type(type)
                .build();
    }
}
