package com.cput.lakey.services.Impli;

import com.cput.lakey.App;
import com.cput.lakey.domain.staff.SpeedTrainer;
import com.cput.lakey.factories.staff.SpeedTrainerFactory;
import com.cput.lakey.repositories.staff.SpeedTrainerRepository;
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
public class SpeedTrainerServiceImpliTest {
    @Autowired
    private SpeedTrainerRepository repository;
    private SpeedTrainer speedTrainer;

    private SpeedTrainer getSavedClass() {
        List<SpeedTrainer> savedGenders = this.repository.findAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        //    Date date = new Date();
        this.speedTrainer = repository.save(SpeedTrainerFactory.getSpeedTrainer(1, "Dillyn", "Lakey", "Boss"));
    }

    @Test
    public void a_create() {
        SpeedTrainer created = this.repository.save(this.speedTrainer);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.speedTrainer);
    }

    @Test
    public void b_read() {
        SpeedTrainer savedSpeedTrainer = getSavedClass();
        System.out.println("In read, genderId = " + savedSpeedTrainer.getIdSpeedTrainer());
        Optional<SpeedTrainer> read = this.repository.findById(savedSpeedTrainer.getIdSpeedTrainer());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertNotNull(read);
    }

    @Test
    public void e_delete() {
        SpeedTrainer savedGender = getSavedClass();
        this.repository.deleteById(savedGender.getIdSpeedTrainer());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive";
        SpeedTrainer speedTrainer = new SpeedTrainer.Builder().copy(getSavedClass()).name(newName).build();
        System.out.println("In update, about_to_updated = " + speedTrainer);
        SpeedTrainer updated = this.repository.save(speedTrainer);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        List<SpeedTrainer> all = this.repository.findAll();
        System.out.println("In getAll, all = " + all);

    }
}