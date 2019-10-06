package com.cput.lakey.domain.staff;

import com.cput.lakey.factories.staff.TrainerFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class TrainerTest {
    @Test
    public void getTrainer() {

        String name = "joe";
        String lastName = "Zoe";
        String title = "Officer";


        Trainer c = TrainerFactory.getTrainer( 1,name,lastName, title);
        System.out.println(c);
        assertNotNull(c.getIdTrainer()+"\n"+c.getName()+"\n"+c.getLastName()+"\n"+c.getTitle());
    }

}