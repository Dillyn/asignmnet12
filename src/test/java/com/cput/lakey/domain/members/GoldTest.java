package com.cput.lakey.domain.members;

import com.cput.lakey.factories.members.GoldMemberFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class GoldTest {
    @Test
    public void getGoldMember() {


        String name = "joe";
        String lastName = "Zoe";


        Gold c = GoldMemberFactory.getClasss(1, name,lastName);
        System.out.println(c);
        assertNotNull(c.getIdGold()+"\n"+c.getName());
    }

}