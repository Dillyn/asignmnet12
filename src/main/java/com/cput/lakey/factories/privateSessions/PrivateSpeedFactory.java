package com.cput.lakey.factories.privateSessions;


import com.cput.lakey.domain.privateSession.PrivateSpeed;
import com.cput.lakey.util.Helper;

import java.util.Date;

public class PrivateSpeedFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(PrivateSpeedFactory.class);

    public static PrivateSpeed getPrivateSpeed(Integer id,Date date, String type) {
        return new PrivateSpeed.Builder()
                .id(id)
                .date(date)
                .type(type)
                .build();
    }
}
