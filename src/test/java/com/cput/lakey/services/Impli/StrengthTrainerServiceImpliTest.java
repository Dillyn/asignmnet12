package com.cput.lakey.services.Impli;

import com.cput.lakey.App;
import com.cput.lakey.domain.staff.StrengthTrainer;
import com.cput.lakey.factories.staff.StrengthTrainerFactory;
import com.cput.lakey.repositories.staff.StrengthTrainerRepository;
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
public class StrengthTrainerServiceImpliTest {
@Autowired
    private StrengthTrainerRepository repository;
    private StrengthTrainer strengthTrainer;

    private StrengthTrainer getSavedClass() {
        List<StrengthTrainer> savedGenders = this.repository.findAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        //    Date date = new Date();
        this.strengthTrainer = repository.save(StrengthTrainerFactory.getStrengthTrainer(1,"Dillyn","Lakey","Boss"));
    }

    @Test
    public void a_create() {
        StrengthTrainer created = this.repository.save(this.strengthTrainer);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.strengthTrainer);
    }

    @Test
    public void b_read() {
        StrengthTrainer savedStrengthTrainer = getSavedClass();
        System.out.println("In read, genderId = "+ savedStrengthTrainer.getIdStrengthTrainer());
        Optional<StrengthTrainer> read = this.repository.findById(savedStrengthTrainer.getIdStrengthTrainer());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertNotNull( read);
    }

    @Test
    public void e_delete() {
        StrengthTrainer savedGender = getSavedClass();
        this.repository.deleteById(savedGender.getIdStrengthTrainer());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive";
        StrengthTrainer strengthTrainer = new StrengthTrainer.Builder().copy(getSavedClass()).name(newName).build();
        System.out.println("In update, about_to_updated = " + strengthTrainer);
        StrengthTrainer updated = this.repository.save(strengthTrainer);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        List<StrengthTrainer> all = this.repository.findAll();
        System.out.println("In getAll, all = " + all);

    }
}