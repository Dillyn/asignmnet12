package com.cput.lakey.domain.privateSession;

import com.cput.lakey.factories.privateSessions.PrivateSessionFactory;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.assertNotNull;

public class PrivateSessionTest {
    @Test
    public void getPrivateSession() throws ParseException {
        // String pattern = "yyyy-MM-dd-15:58";
    //SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    Date date = new Date();
    String type = "turbo";
    //date = simpleDateFormat.parse("2018-09-09");


    PrivateSession c = PrivateSessionFactory.getPrivateSession(1,date,type);
        System.out.println(c);
                assertNotNull(c.getPrivateSessionDate()+"\n"+c.getType());
                }
}