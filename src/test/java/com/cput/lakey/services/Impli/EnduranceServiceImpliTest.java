package com.cput.lakey.services.Impli;

import com.cput.lakey.App;
import com.cput.lakey.domain.classes.Endurance;
import com.cput.lakey.factories.classes.EnduranceClassFactory;
import com.cput.lakey.repositories.classes.EnduranceRepository;
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

public class EnduranceServiceImpliTest {
@Autowired
    private EnduranceRepository repository;
    private Endurance endurance;

    private Endurance getSavedClass() {
        List<Endurance> savedGenders = this.repository.findAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.endurance = this.repository.save(EnduranceClassFactory.getClasss(1,"Spinning"));
    }

    @Test
    public void a_create() {
        Endurance created = this.repository.save(this.endurance);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.endurance);
    }

    @Test
    public void b_read() {
        Endurance savedEndurance = getSavedClass();
        System.out.println("In read, genderId = "+ savedEndurance.getIdClass());
        Optional<Endurance> read = this.repository.findById(savedEndurance.getIdClass());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertNotNull(savedEndurance);
    }

    @Test
    public void e_delete() {
        Endurance savedGender = getSavedClass();
        this.repository.deleteById(savedGender.getIdClass());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive";
        Endurance endurance = new Endurance.Builder().copy(getSavedClass()).name(newName).build();
        System.out.println("In update, about_to_updated = " + endurance);
        Endurance updated = this.repository.save(endurance);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        List<Endurance> all = this.repository.findAll();
        System.out.println("In getAll, all = " + all);

    }
}