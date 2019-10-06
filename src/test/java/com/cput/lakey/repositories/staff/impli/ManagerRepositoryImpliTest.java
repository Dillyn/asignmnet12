package com.cput.lakey.repositories.staff.impli;

import com.cput.lakey.App;
import com.cput.lakey.domain.staff.Manager;
import com.cput.lakey.factories.staff.ManagerFactory;
import com.cput.lakey.repositories.staff.ManagerRepository;
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
public class ManagerRepositoryImpliTest {
@Autowired
    private ManagerRepository repository;
    private Manager manager;

    private Manager getSavedClass() {
        List<Manager> savedGenders = this.repository.findAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        //    Date date = new Date();
        this.manager = repository.save(ManagerFactory.getManager(1,"Dillyn","Lakey","Boss"));
    }

    @Test
    public void a_create() {
        Manager created = this.repository.save(this.manager);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.manager);
    }

    @Test
    public void b_read() {
        Manager savedManager = getSavedClass();
        System.out.println("In read, genderId = "+ savedManager.getIdManager());
        Optional<Manager> read = this.repository.findById(savedManager.getIdManager());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertNotNull( read);
    }

    @Test
    public void e_delete() {
        Manager savedGender = getSavedClass();
        this.repository.deleteById(savedGender.getIdManager());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive";
        Manager manager = new Manager.Builder().copy(getSavedClass()).name(newName).build();
        System.out.println("In update, about_to_updated = " + manager);
        Manager updated = this.repository.save(manager);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        List<Manager> all = this.repository.findAll();
        System.out.println("In getAll, all = " + all);

    }
}