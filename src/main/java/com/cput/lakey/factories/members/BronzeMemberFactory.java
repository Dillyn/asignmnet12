package com.cput.lakey.factories.members;

import com.cput.lakey.domain.members.Bronze;
import com.cput.lakey.util.Helper;


public class BronzeMemberFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(BronzeMemberFactory.class);

    public static Bronze getClasss(Integer id,String name, String lastName) {
        return new Bronze.Builder()
                .idBronze(id)
                .name(name)
                .lastName(lastName)
                .build();
    }
}

