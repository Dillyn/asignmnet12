package com.cput.lakey.domain.members;

import com.cput.lakey.factories.members.BronzeMemberFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class BronzeTest {
    @Test
    public void getBronzeMember() {


        String name = "joe";
        String lastName = "Zoe";


        Bronze c = BronzeMemberFactory.getClasss(1, name,lastName);
        System.out.println(c);
        assertNotNull(c.getIdBronze()+"\n"+c.getName());
    }

}