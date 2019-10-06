package com.cput.lakey.domain.studio;

import com.cput.lakey.factories.studio.StudioFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class StudioTest {
    @Test
    public void getStudio() {


        String name = "Studio1";



        Studio c = StudioFactory.getStudio( 1,name);
        System.out.println(c);
        assertNotNull(c.getName());
    }

}