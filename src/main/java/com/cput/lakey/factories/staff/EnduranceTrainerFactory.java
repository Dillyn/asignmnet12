package com.cput.lakey.factories.staff;

import com.cput.lakey.domain.staff.EnduranceTrainer;
import com.cput.lakey.util.Helper;

public class EnduranceTrainerFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(EnduranceTrainerFactory.class);

    public static EnduranceTrainer getEnduranceTrainer(Integer id, String name, String lastName, String title) {
        return new EnduranceTrainer.Builder()
                .idEnduranceTrainer(id)
                .name(name)
                .lastName(lastName)
                .title(title)
                .build();
    }
}