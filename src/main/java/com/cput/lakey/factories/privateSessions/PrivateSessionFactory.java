package com.cput.lakey.factories.privateSessions;

import com.cput.lakey.domain.privateSession.PrivateSession;
import com.cput.lakey.util.Helper;

import java.util.Date;

public class PrivateSessionFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(PrivateSessionFactory.class);

    public static PrivateSession getPrivateSession(Integer id,Date date,String type) {
            return new PrivateSession.Builder()
                    .id( id)
                    .date(date)
                    .type(type)
                    .build();
        }
    }
