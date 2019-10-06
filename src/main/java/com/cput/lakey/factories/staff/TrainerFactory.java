package com.cput.lakey.factories.staff;

import com.cput.lakey.domain.staff.Trainer;
import com.cput.lakey.util.Helper;

public class TrainerFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(TrainerFactory.class);

    public static Trainer getTrainer( Integer id,String name, String lastName, String title) {
        return new Trainer.Builder()
                .idTrainer(id)
                .name(name)
                .lastName(lastName)
                .title(title)
                .build();
    }
}
