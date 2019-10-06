package com.cput.lakey.domain.members;


import com.cput.lakey.factories.members.MemberFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class MemberTest {
    @Test
    public void getMember() {


        String name = "joe";
        String lastName = "Zoe";


        Member c = MemberFactory.getClasss(1,name,lastName);
        System.out.println(c);
        assertNotNull(c.getIdMember()+"\n"+c.getName());
    }

}