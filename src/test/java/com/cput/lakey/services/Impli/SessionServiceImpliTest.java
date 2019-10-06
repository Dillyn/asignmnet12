package com.cput.lakey.services.Impli;

import com.cput.lakey.App;
import com.cput.lakey.domain.session.Session;
import com.cput.lakey.factories.session.SessionFactory;
import com.cput.lakey.repositories.session.SessionRepository;
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
public class SessionServiceImpliTest {
@Autowired
    private SessionRepository repository;
    private Session session;

    private Session getSavedClass() {
        List<Session> savedGenders = this.repository.findAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        //    Date date = new Date();
        this.session = repository.save(SessionFactory.getSession(1,new Date()));
    }

    @Test
    public void a_create() {
        Session created = this.repository.save(this.session);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.session);
    }

    @Test
    public void b_read() {
        Session savedSession = getSavedClass();
        System.out.println("In read, genderId = "+ savedSession.getId());
        Optional<Session> read = this.repository.findById(savedSession.getId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertNotNull( read);
    }

    @Test
    public void e_delete() {
        Session savedGender = getSavedClass();
        this.repository.deleteById(savedGender.getId());
        d_getAll();
    }

    @Test
    public void c_update() {
        Date newName = new Date();
        Session session = new Session.Builder().copy(getSavedClass()).date(newName).build();
        System.out.println("In update, about_to_updated = " + session);
        Session updated = this.repository.save(session);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(session.getId(), updated.getId());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        List<Session> all = this.repository.findAll();
        System.out.println("In getAll, all = " + all);

    }
}