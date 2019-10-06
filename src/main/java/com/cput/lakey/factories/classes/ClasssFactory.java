package com.cput.lakey.factories.classes;

import com.cput.lakey.domain.classes.Classs;
import com.cput.lakey.util.Helper;

public class ClasssFactory {

    private static final String SUFFIX = Helper.getSuffixFromClassName(ClasssFactory.class);

    public static Classs getClasss(Integer id, String name) {
        return new Classs.Builder()
                .idClass(id)
                .name(name)
                .build();
    }
}
