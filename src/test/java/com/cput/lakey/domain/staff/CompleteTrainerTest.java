package com.cput.lakey.domain.staff;

import com.cput.lakey.factories.staff.CompleteTrainerFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CompleteTrainerTest {
    @Test
    public void getTrainer() {


        String name = "joe";
        String lastName = "Zoe";
        String title = "Officer";


        CompleteTrainer c = CompleteTrainerFactory.getCompleteTrainer(1, name,lastName, title);
        System.out.println(c);
        assertNotNull(c.getIdCompleteTrainer()+"\n"+c.getName()+"\n"+c.getLastName()+"\n"+c.getTitle());
    }

}