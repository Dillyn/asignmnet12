package com.cput.lakey.factories.staff;

import com.cput.lakey.domain.staff.StrengthTrainer;
import com.cput.lakey.util.Helper;

public class StrengthTrainerFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(StrengthTrainerFactory.class);

    public static StrengthTrainer getStrengthTrainer(Integer id, String name, String lastName, String title) {
        return new StrengthTrainer.Builder()
                .idStrengthTrainer(id)
                .name(name)
                .lastName(lastName)
                .title(title)
                .build();
    }
}
