package com.cput.lakey.domain.classes;

import com.cput.lakey.factories.classes.EnduranceClassFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class EnduranceTest {

    @Test
    public void getenduranceClasss() {


        String name = "Sprint";


        Endurance c = EnduranceClassFactory.getClasss(1, name);
        System.out.println(c);
        assertNotNull(c.getIdClass()+"\n"+c.getName());
    }

}