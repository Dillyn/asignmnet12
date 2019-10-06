package com.cput.lakey.services.Impli;

import com.cput.lakey.App;
import com.cput.lakey.domain.privateSession.PrivateSession;
import com.cput.lakey.factories.privateSessions.PrivateSessionFactory;
import com.cput.lakey.repositories.privateSession.PrivateSessionRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = App.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class PrivateSessionServiceImpliTest {
@Autowired
    private PrivateSessionRepository repository;
    private PrivateSession privateSession;

    private PrivateSession getSavedClass() {
        List<PrivateSession> savedGenders = this.repository.findAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
    //    Date date = new Date();
        this.privateSession = this.repository.save(PrivateSessionFactory.getPrivateSession(1,new Date(), "Strength"));
    }

    @Test
    public void a_create() {
        PrivateSession created = this.repository.save(this.privateSession);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.privateSession);
    }

    @Test
    public void b_read() {
        PrivateSession savedPrivateSession = getSavedClass();
        System.out.println("In read, genderId = "+ savedPrivateSession.getId());
        Optional<PrivateSession> read = this.repository.findById(savedPrivateSession.getId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertNotNull( read);
    }

    @Test
    public void e_delete() {
        PrivateSession savedGender = getSavedClass();
        this.repository.deleteById(savedGender.getId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive";
        PrivateSession privateSession = new PrivateSession.Builder().copy(getSavedClass()).type(newName).build();
        System.out.println("In update, about_to_updated = " + privateSession);
        PrivateSession updated = this.repository.save(privateSession);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getType());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        List<PrivateSession> all = this.repository.findAll();
        System.out.println("In getAll, all = " + all);

    }
}