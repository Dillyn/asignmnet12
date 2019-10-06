package com.cput.lakey.factories.session;

import com.cput.lakey.domain.session.Session;
import com.cput.lakey.util.Helper;

import java.util.Date;

public class SessionFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(SessionFactory.class);

    public static Session getSession(Integer id,Date date) {
        return new Session.Builder()
                .id(id)
                .date(date)
                .build();
    }
}