package com.cput.lakey.services.Impli;

import com.cput.lakey.App;
import com.cput.lakey.domain.privateSession.PrivateEndurance;
import com.cput.lakey.factories.privateSessions.PrivateEnduranceFactory;
import com.cput.lakey.repositories.privateSession.PrivateEnduranceRepository;
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
public class PrivateEnduranceServiceImpliTest {
    @Autowired
    private PrivateEnduranceRepository repository;
    private PrivateEndurance privateEndurance;

    private PrivateEndurance getSavedClass() {
        List<PrivateEndurance> savedGenders = this.repository.findAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        //    Date date = new Date();
        this.privateEndurance = repository.save(PrivateEnduranceFactory.getPrivateEndurance(1, new Date(), "Endurance"));
    }

    @Test
    public void a_create() {
        PrivateEndurance created = this.repository.save(this.privateEndurance);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.privateEndurance);
    }

    @Test
    public void b_read() {
        PrivateEndurance savedPrivateEndurance = getSavedClass();
        System.out.println("In read, genderId = " + savedPrivateEndurance.getId());
        Optional<PrivateEndurance> read = this.repository.findById(savedPrivateEndurance.getId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertNotNull(read);
    }

    @Test
    public void e_delete() {
        PrivateEndurance savedGender = getSavedClass();
        this.repository.deleteById(savedGender.getId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive Endurance";
        PrivateEndurance privateEndurance = new PrivateEndurance.Builder().copy(getSavedClass()).type(newName).build();
        System.out.println("In update, about_to_updated = " + privateEndurance);
        PrivateEndurance updated = this.repository.save(privateEndurance);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getType());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        List<PrivateEndurance> all = this.repository.findAll();
        System.out.println("In getAll, all = " + all);

    }
}