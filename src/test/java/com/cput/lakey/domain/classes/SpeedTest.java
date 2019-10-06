package com.cput.lakey.domain.classes;

import com.cput.lakey.factories.classes.SpeedClassFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class SpeedTest {
    @Test
    public void getClasss() {


        String name = "Explosive";


        Speed c = SpeedClassFactory.getClasss(1, name);
        System.out.println(c);
        assertNotNull(c.getIdClass()+"\n"+c.getName());
    }

}