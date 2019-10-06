package com.cput.lakey.factories.staff;

import com.cput.lakey.domain.staff.Staff;
import com.cput.lakey.util.Helper;

public class StaffFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(StaffFactory.class);

    public static Staff getStaff(Integer id,String name, String lastName, String title) {
        return new Staff.Builder()
                .idStaff(id)
                .name(name)
                .lastName(lastName)
                .title(title)
                .build();
    }
}
