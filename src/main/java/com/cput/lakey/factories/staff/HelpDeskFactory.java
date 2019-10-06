package com.cput.lakey.factories.staff;

import com.cput.lakey.domain.staff.HelpDesk;
import com.cput.lakey.util.Helper;

public class HelpDeskFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(HelpDeskFactory.class);

    public static HelpDesk getHelpDesk(Integer id, String name, String lastName, String title) {
        return new HelpDesk.Builder()
                .idHelpDesk(id)
                .name(name)
                .lastName(lastName)
                .title(title)
                .build();
    }
}
