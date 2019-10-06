package com.cput.lakey.domain.members;

import com.cput.lakey.factories.members.SilverMemberFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class SilverTest {
    @Test
    public void getSilverMember() {


        String name = "joe";
        String lastName = "Zoe";


        Silver c = SilverMemberFactory.getClasss( 1,name,lastName);
        System.out.println(c);
        assertNotNull(c.getIdSilver()+"\n"+c.getName());
    }

}