package com.cput.lakey.services.Impli;

import com.cput.lakey.App;
import com.cput.lakey.domain.staff.EnduranceTrainer;
import com.cput.lakey.factories.staff.EnduranceTrainerFactory;
import com.cput.lakey.repositories.staff.EnduranceTrainerRepository;
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
public class EnduranceTrainerServiceImpliTest {
@Autowired
    private EnduranceTrainerRepository repository;
    private EnduranceTrainer enduranceTrainer;

    private EnduranceTrainer getSavedClass() {
        List<EnduranceTrainer> savedGenders = this.repository.findAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        //    Date date = new Date();
        this.enduranceTrainer = repository.save(EnduranceTrainerFactory.getEnduranceTrainer(1,"Dillyn","Lakey","Boss"));
    }

    @Test
    public void a_create() {
        EnduranceTrainer created = this.repository.save(this.enduranceTrainer);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.enduranceTrainer);
    }

    @Test
    public void b_read() {
        EnduranceTrainer savedEnduranceTrainer = getSavedClass();
        System.out.println("In read, genderId = "+ savedEnduranceTrainer.getIdEnduranceTrainer());
        Optional<EnduranceTrainer> read = this.repository.findById(savedEnduranceTrainer.getIdEnduranceTrainer());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertNotNull( read);
    }

    @Test
    public void e_delete() {
        EnduranceTrainer savedGender = getSavedClass();
        this.repository.deleteById(savedGender.getIdEnduranceTrainer());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive";
        EnduranceTrainer enduranceTrainer = new EnduranceTrainer.Builder().copy(getSavedClass()).name(newName).build();
        System.out.println("In update, about_to_updated = " + enduranceTrainer);
        EnduranceTrainer updated = this.repository.save(enduranceTrainer);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        List<EnduranceTrainer> all = this.repository.findAll();
        System.out.println("In getAll, all = " + all);

    }
}