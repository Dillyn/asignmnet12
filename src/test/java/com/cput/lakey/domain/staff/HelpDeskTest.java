package com.cput.lakey.domain.staff;

import com.cput.lakey.factories.staff.HelpDeskFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class HelpDeskTest {
    @Test
    public void getHelpDesk() {


        String name = "joe";
        String lastName = "Zoe";
        String title = "helper";


        HelpDesk c = HelpDeskFactory.getHelpDesk(1, name,lastName, title);
        System.out.println(c);
        assertNotNull(c.getIdHelpDesk()+"\n"+c.getName()+"\n"+c.getLastName()+"\n"+c.getTitle());
    }

}