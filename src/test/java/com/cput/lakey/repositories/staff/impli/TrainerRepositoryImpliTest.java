package com.cput.lakey.repositories.staff.impli;

import com.cput.lakey.App;
import com.cput.lakey.domain.staff.Trainer;
import com.cput.lakey.factories.staff.TrainerFactory;
import com.cput.lakey.repositories.staff.TrainerRepository;
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
public class TrainerRepositoryImpliTest {
@Autowired
    private TrainerRepository repository;
    private Trainer trainer;

    private Trainer getSavedClass() {
        List<Trainer> savedGenders = this.repository.findAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        //    Date date = new Date();
        this.trainer = repository.save(TrainerFactory.getTrainer(1,"Dillyn","Lakey","Boss"));
    }

    @Test
    public void a_create() {
        Trainer created = this.repository.save(this.trainer);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.trainer);
    }

    @Test
    public void b_read() {
        Trainer savedTrainer = getSavedClass();
        System.out.println("In read, genderId = "+ savedTrainer.getIdTrainer());
        Optional<Trainer> read = this.repository.findById(savedTrainer.getIdTrainer());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertNotNull( read);
    }

    @Test
    public void e_delete() {
        Trainer savedGender = getSavedClass();
        this.repository.deleteById(savedGender.getIdTrainer());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive";
        Trainer trainer = new Trainer.Builder().copy(getSavedClass()).name(newName).build();
        System.out.println("In update, about_to_updated = " + trainer);
        Trainer updated = this.repository.save(trainer);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        List<Trainer> all = this.repository.findAll();
        System.out.println("In getAll, all = " + all);

    }
}