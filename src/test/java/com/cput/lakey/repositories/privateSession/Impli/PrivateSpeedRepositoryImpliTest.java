package com.cput.lakey.repositories.privateSession.Impli;

import com.cput.lakey.App;
import com.cput.lakey.domain.privateSession.PrivateSpeed;
import com.cput.lakey.factories.privateSessions.PrivateSpeedFactory;
import com.cput.lakey.repositories.privateSession.PrivateSpeedRepository;
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
public class PrivateSpeedRepositoryImpliTest {
@Autowired
    private PrivateSpeedRepository repository;
    private PrivateSpeed privateSpeed;

    private PrivateSpeed getSavedClass() {
        List<PrivateSpeed> savedGenders = this.repository.findAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        //    Date date = new Date();
        this.privateSpeed =repository.save( PrivateSpeedFactory.getPrivateSpeed(1,new Date(), "Speed"));
    }

    @Test
    public void a_create() {
        PrivateSpeed created = this.repository.save(this.privateSpeed);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.privateSpeed);
    }

    @Test
    public void b_read() {
        PrivateSpeed savedPrivateSpeed = getSavedClass();
        System.out.println("In read, genderId = "+ savedPrivateSpeed.getId());
        Optional<PrivateSpeed> read = this.repository.findById(savedPrivateSpeed.getId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertNotNull( read);
    }

    @Test
    public void e_delete() {
        PrivateSpeed savedGender = getSavedClass();
        this.repository.deleteById(savedGender.getId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive Speed";
        PrivateSpeed privateSpeed = new PrivateSpeed.Builder().copy(getSavedClass()).type(newName).build();
        System.out.println("In update, about_to_updated = " + privateSpeed);
        PrivateSpeed updated = this.repository.save(privateSpeed);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getType());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        List<PrivateSpeed> all = this.repository.findAll();
        System.out.println("In getAll, all = " + all);

    }
}