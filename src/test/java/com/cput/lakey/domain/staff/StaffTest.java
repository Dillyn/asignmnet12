package com.cput.lakey.domain.staff;

import com.cput.lakey.factories.staff.StaffFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class StaffTest {
    @Test
    public void getStaff() {


        String name = "joe";
        String lastName = "Zoe";
        String title = "Officer";


        Staff c = StaffFactory.getStaff(1,name,lastName, title);
        System.out.println(c);
        assertNotNull(c.getIdStaff()+"\n"+c.getName()+"\n"+c.getLastName()+"\n"+c.getTitle());
    }

}