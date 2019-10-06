package com.cput.lakey.repositories.classes.Impli;

import com.cput.lakey.App;
import com.cput.lakey.domain.classes.Strength;
import com.cput.lakey.factories.classes.StrengthClassFactory;
import com.cput.lakey.repositories.classes.StrengthRepository;
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
@ContextConfiguration(classes = App.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StrengthRepositoryImpliTest {
@Autowired
    private StrengthRepository repository;
    private Strength strength;

    private Strength getSavedClass() {
        List<Strength> savedGenders = this.repository.findAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.strength = repository.save(StrengthClassFactory.getClasss(1,"Sprint"));
    }

    @Test
    public void a_create() {
        Strength created = this.repository.save(this.strength);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.strength);
    }

    @Test
    public void b_read() {
        Strength savedStrength = getSavedClass();
        System.out.println("In read, genderId = "+ savedStrength.getIdClass());
        Optional<Strength> read = this.repository.findById(savedStrength.getIdClass());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertNotNull(savedStrength);
    }

    @Test
    public void e_delete() {
        Strength savedGender = getSavedClass();
        this.repository.deleteById(savedGender.getIdClass());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive";
        Strength Strength = new Strength.Builder().copy(getSavedClass()).name(newName).build();
        System.out.println("In update, about_to_updated = " + Strength);
        Strength updated = this.repository.save(Strength);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        List<Strength> all = this.repository.findAll();
        System.out.println("In getAll, all = " + all);

    }
}