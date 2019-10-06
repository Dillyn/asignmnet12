package com.cput.lakey.factories.members;

import com.cput.lakey.domain.members.Member;
import com.cput.lakey.util.Helper;

public class MemberFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(MemberFactory.class);

    public static Member getClasss( Integer id,String name, String lastName) {
        return new Member.Builder()
                .idMember(id)
                .name(name)
                .lastName(lastName)
                .build();
    }
}
