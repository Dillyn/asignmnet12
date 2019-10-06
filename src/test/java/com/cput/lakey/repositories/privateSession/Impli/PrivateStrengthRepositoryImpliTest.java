package com.cput.lakey.repositories.privateSession.Impli;

import com.cput.lakey.App;
import com.cput.lakey.domain.privateSession.PrivateStrength;
import com.cput.lakey.factories.privateSessions.PrivateStrengthFactory;
import com.cput.lakey.repositories.privateSession.PrivateStrengthRepository;
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
public class PrivateStrengthRepositoryImpliTest {
@Autowired
    private PrivateStrengthRepository repository;
    private PrivateStrength privateStrength;

    private PrivateStrength getSavedClass() {
        List<PrivateStrength> savedGenders = this.repository.findAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        //    Date date = new Date();
        this.privateStrength = repository.save(PrivateStrengthFactory.getPrivateStrength(1,new Date(), "Strength"));
    }

    @Test
    public void a_create() {
        PrivateStrength created = this.repository.save(this.privateStrength);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.privateStrength);
    }

    @Test
    public void b_read() {
        PrivateStrength savedPrivateStrength = getSavedClass();
        System.out.println("In read, genderId = "+ savedPrivateStrength.getId());

        Optional<PrivateStrength> read = this.repository.findById(savedPrivateStrength.getId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertNotNull(read);
    }

    @Test
    public void e_delete() {
        PrivateStrength savedGender = getSavedClass();
        this.repository.deleteById(savedGender.getId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive Strength";
        PrivateStrength privateStrength = new PrivateStrength.Builder().copy(getSavedClass()).type(newName).build();
        System.out.println("In update, about_to_updated = " + privateStrength);
        PrivateStrength updated = this.repository.save(privateStrength);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getType());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        List<PrivateStrength> all = this.repository.findAll();
        System.out.println("In getAll, all = " + all);

    }
}