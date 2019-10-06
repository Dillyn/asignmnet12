package com.cput.lakey.domain.staff;

import com.cput.lakey.factories.staff.SpeedTrainerFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class SpeedTrainerTest {
    @Test
    public void getTrainer() {


        String name = "joe";
        String lastName = "Zoe";
        String title = "Officer";


        SpeedTrainer c = SpeedTrainerFactory.getSpeedTrainer(1,name,lastName, title);
        System.out.println(c);
        assertNotNull(c.getIdSpeedTrainer()+"\n"+c.getName()+"\n"+c.getLastName()+"\n"+c.getTitle());
    }

}