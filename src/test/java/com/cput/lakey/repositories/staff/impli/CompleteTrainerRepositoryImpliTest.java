package com.cput.lakey.repositories.staff.impli;

import com.cput.lakey.App;
import com.cput.lakey.domain.staff.CompleteTrainer;
import com.cput.lakey.factories.staff.CompleteTrainerFactory;
import com.cput.lakey.repositories.staff.CompleteTrainerRepository;
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
public class CompleteTrainerRepositoryImpliTest {
@Autowired
    private CompleteTrainerRepository repository;
    private CompleteTrainer completeTrainer;

    private CompleteTrainer getSavedClass() {
        List<CompleteTrainer> savedGenders = this.repository.findAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        //    Date date = new Date();
        this.completeTrainer = repository.save(CompleteTrainerFactory.getCompleteTrainer(1,"Dillyn","Lakey","Boss"));
    }

    @Test
    public void a_create() {
        CompleteTrainer created = this.repository.save(this.completeTrainer);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.completeTrainer);
    }

    @Test
    public void b_read() {
        CompleteTrainer savedCompleteTrainer = getSavedClass();
        System.out.println("In read, genderId = "+ savedCompleteTrainer.getIdCompleteTrainer());
        Optional<CompleteTrainer> read = this.repository.findById(savedCompleteTrainer.getIdCompleteTrainer());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertNotNull( read);
    }

    @Test
    public void e_delete() {
        CompleteTrainer savedGender = getSavedClass();
        this.repository.deleteById(savedGender.getIdCompleteTrainer());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive";
        CompleteTrainer completeTrainer = new CompleteTrainer.Builder().copy(getSavedClass()).name(newName).build();
        System.out.println("In update, about_to_updated = " + completeTrainer);
        CompleteTrainer updated = this.repository.save(completeTrainer);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        List<CompleteTrainer> all = this.repository.findAll();
        System.out.println("In getAll, all = " + all);

    }
}