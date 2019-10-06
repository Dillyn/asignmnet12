package com.cput.lakey.factories.classes;

import com.cput.lakey.domain.classes.Strength;
import com.cput.lakey.util.Helper;

public class StrengthClassFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(StrengthClassFactory.class);

    public static Strength getClasss(Integer id, String name) {
        return new Strength.Builder()
                .idClass(id)
                .name(name)
                .build();
    }
}
