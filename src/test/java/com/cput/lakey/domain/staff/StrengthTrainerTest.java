package com.cput.lakey.domain.staff;

import com.cput.lakey.factories.staff.StrengthTrainerFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class StrengthTrainerTest {
    @Test
    public void getStrengthTrainer() {


        String name = "joe";
        String lastName = "Zoe";
        String title = "Officer";


        StrengthTrainer c = StrengthTrainerFactory.getStrengthTrainer(1, name,lastName, title);
        System.out.println(c);
        assertNotNull(c.getIdStrengthTrainer()+"\n"+c.getName()+"\n"+c.getLastName()+"\n"+c.getTitle());
    }

}