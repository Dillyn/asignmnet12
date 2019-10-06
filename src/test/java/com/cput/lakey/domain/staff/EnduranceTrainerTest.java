package com.cput.lakey.domain.staff;

import com.cput.lakey.factories.staff.EnduranceTrainerFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class EnduranceTrainerTest {
    @Test
    public void getTrainer() {


        String name = "joe";
        String lastName = "Zoe";
        String title = "Officer";


        EnduranceTrainer c = EnduranceTrainerFactory.getEnduranceTrainer(1, name,lastName, title);
        System.out.println(c);
        assertNotNull(c.getIdEnduranceTrainer()+"\n"+c.getName()+"\n"+c.getLastName()+"\n"+c.getTitle());
    }

}