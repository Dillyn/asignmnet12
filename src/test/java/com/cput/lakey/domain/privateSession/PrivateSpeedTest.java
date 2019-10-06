package com.cput.lakey.domain.privateSession;

import com.cput.lakey.factories.privateSessions.PrivateSpeedFactory;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertNotNull;

public class PrivateSpeedTest {

    @Test
    public void getPrivateEnduranceSession() {
        // String pattern = "yyyy-MM-dd-15:58";
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = new Date();
        String type = "turbo";
        //date = simpleDateFormat.parse("2018-09-09");


        PrivateSpeed c = PrivateSpeedFactory.getPrivateSpeed(1,date,type);
        System.out.println(c);
        assertNotNull(c.getDate()+"\n"+c.getType());
    }
}