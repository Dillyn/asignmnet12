package com.cput.lakey.factories.staff;

import com.cput.lakey.domain.staff.CompleteTrainer;
import com.cput.lakey.util.Helper;

public class CompleteTrainerFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(CompleteTrainerFactory.class);

    public static CompleteTrainer getCompleteTrainer(Integer id, String name, String lastName, String title) {
        return new CompleteTrainer.Builder()
                .idCompleteTrainer(id)
                .name(name)
                .lastName(lastName)
                .title(title)
                .build();
    }
}
