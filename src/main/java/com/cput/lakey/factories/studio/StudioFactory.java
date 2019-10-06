package com.cput.lakey.factories.studio;

import com.cput.lakey.domain.studio.Studio;
import com.cput.lakey.util.Helper;

public class StudioFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(StudioFactory.class);

    public static Studio getStudio(Integer id,String name) {
        return new Studio.Builder()
                .id(id)
                .name(name)
                .build();
    }
}
