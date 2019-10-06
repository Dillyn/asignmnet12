package com.cput.lakey.factories.classes;

import com.cput.lakey.domain.classes.Endurance;
import com.cput.lakey.util.Helper;

public class EnduranceClassFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(EnduranceClassFactory.class);

    public static Endurance getClasss(Integer id,String name) {
        return new Endurance.Builder()
                .idClass(id)
                .name(name)
                .build();
    }
}
