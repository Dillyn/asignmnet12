package com.cput.lakey.factories.staff;

import com.cput.lakey.domain.staff.SpeedTrainer;
import com.cput.lakey.util.Helper;

public class SpeedTrainerFactory {
    private static final String SUFFIX = Helper.getSuffixFromClassName(SpeedTrainerFactory.class);

    public static SpeedTrainer getSpeedTrainer( Integer id,String name, String lastName, String title) {
        return new SpeedTrainer.Builder()
                .idSpeedTrainer(id)
                .name(name)
                .lastName(lastName)
                .title(title)
                .build();
    }
}
