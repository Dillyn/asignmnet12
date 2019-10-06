package com.cput.lakey.domain.classes;

import com.cput.lakey.factories.classes.ClasssFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ClasssTest {

    @Test
    public void getClasss() {


        String name = "Zumba";


        Classs c = ClasssFactory.getClasss(1, name);
        System.out.println(c);
        assertNotNull(c.getIdClass()+"\n"+c.getName());
    }

}