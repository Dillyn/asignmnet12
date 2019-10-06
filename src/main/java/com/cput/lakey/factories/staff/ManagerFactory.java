package com.cput.lakey.factories.staff;

import com.cput.lakey.domain.staff.Manager;
import com.cput.lakey.util.Helper;

public class ManagerFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(ManagerFactory.class);

    public static Manager getManager(Integer id, String name, String lastName, String title) {
        return new Manager.Builder()
                .idManager(id)
                .name(name)
                .lastName(lastName)
                .title(title)
                .build();
    }
}