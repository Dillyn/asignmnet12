package com.cput.lakey.services.Impli;

import com.cput.lakey.App;
import com.cput.lakey.domain.classes.Speed;
import com.cput.lakey.factories.classes.SpeedClassFactory;
import com.cput.lakey.repositories.classes.SpeedRepository;
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

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration(classes = App.class)

public class SpeedServiceImpliTest {
@Autowired
    private SpeedRepository repository;
    private Speed speed;

    private Speed getSavedClass() {
        List<Speed> savedGenders = this.repository.findAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.speed = repository.save(SpeedClassFactory.getClasss(1,"Sprint"));
    }

    @Test
    public void a_create() {
        Speed created = this.repository.save(this.speed);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.speed);
    }

    @Test
    public void b_read() {
        Speed savedSpeed = getSavedClass();
        System.out.println("In read, genderId = "+ savedSpeed.getIdClass());
        Optional<Speed> read = this.repository.findById(savedSpeed.getIdClass());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertNotNull( read);
    }

    @Test
    public void e_delete() {
        Speed savedGender = getSavedClass();
        this.repository.deleteById(savedGender.getIdClass());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive";
        Speed Speed = new Speed.Builder().copy(getSavedClass()).name(newName).build();
        System.out.println("In update, about_to_updated = " + Speed);
        Speed updated = this.repository.save(Speed);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        List<Speed> all = this.repository.findAll();
        System.out.println("In getAll, all = " + all);

    }
}