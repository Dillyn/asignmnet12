package com.cput.lakey.services.Impli;

import com.cput.lakey.App;
import com.cput.lakey.domain.studio.Studio;
import com.cput.lakey.factories.studio.StudioFactory;
import com.cput.lakey.repositories.studio.StudioRepository;
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
public class StudioServicempliTest {
@Autowired
    private StudioRepository repository;
    private Studio studio;

    private Studio getSavedClass() {
        List<Studio> savedGenders = this.repository.findAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        //    Date date = new Date();
        this.studio = repository.save(StudioFactory.getStudio(1,"Dillyn"));
    }

    @Test
    public void a_create() {
        Studio created = this.repository.save(this.studio);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.studio);
    }

    @Test
    public void b_read() {
        Studio savedStudio = getSavedClass();
        System.out.println("In read, genderId = "+ savedStudio.getId());
        Optional<Studio> read = this.repository.findById(savedStudio.getId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertNotNull( read);
    }

    @Test
    public void e_delete() {
        Studio savedGender = getSavedClass();
        this.repository.deleteById(savedGender.getId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive";
        Studio studio = new Studio.Builder().copy(getSavedClass()).name(newName).build();
        System.out.println("In update, about_to_updated = " + studio);
        Studio updated = this.repository.save(studio);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        List<Studio> all = this.repository.findAll();
        System.out.println("In getAll, all = " + all);

    }
}