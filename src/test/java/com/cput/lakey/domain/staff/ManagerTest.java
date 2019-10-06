package com.cput.lakey.domain.staff;

import com.cput.lakey.factories.staff.ManagerFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ManagerTest {
    @Test
    public void getManager() {


        String name = "joe";
        String lastName = "Zoe";
        String title = "Officer";


        Manager c = ManagerFactory.getManager(1,name,lastName, title);
        System.out.println(c);
        assertNotNull(c.getIdManager()+"\n"+c.getName()+"\n"+c.getLastName()+"\n"+c.getTitle());
    }

}