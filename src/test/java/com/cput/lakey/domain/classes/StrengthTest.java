package com.cput.lakey.domain.classes;

import com.cput.lakey.factories.classes.StrengthClassFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class StrengthTest {
    @Test
    public void getClasss() {

        String name = "Strength";


        Strength c = StrengthClassFactory.getClasss( 1,name);
        System.out.println(c);
        assertNotNull(c.getIdClass()+"\n"+c.getName());
    }

}