package com.cput.lakey.factories.members;

import com.cput.lakey.domain.members.Silver;
import com.cput.lakey.util.Helper;

public class SilverMemberFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(SilverMemberFactory.class);

    public static Silver getClasss( Integer id,String name, String lastName) {
        return new Silver.Builder()
                .idSilver(id)
                .name(name)
                .lastName(lastName)
                .build();
    }
}
