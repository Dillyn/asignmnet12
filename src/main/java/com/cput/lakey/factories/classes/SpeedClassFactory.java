package com.cput.lakey.factories.classes;

import com.cput.lakey.domain.classes.Speed;
import com.cput.lakey.util.Helper;

public class SpeedClassFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(SpeedClassFactory.class);

    public static Speed getClasss(Integer id,String name) {
        return new Speed.Builder()
                .idClass(id)
                .name(name)
                .build();
    }
}
