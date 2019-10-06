package com.cput.lakey.factories.members;

import com.cput.lakey.domain.members.Gold;
import com.cput.lakey.util.Helper;

public class GoldMemberFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(GoldMemberFactory.class);

    public static Gold getClasss(Integer id, String name, String lastName) {
        return new Gold.Builder()
                .idGold(id)
                .name(name)
                .lastName(lastName)
                .build();
    }
}
