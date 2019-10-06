package com.cput.lakey.services.Impli;

import com.cput.lakey.App;
import com.cput.lakey.domain.members.Bronze;
import com.cput.lakey.factories.members.BronzeMemberFactory;
import com.cput.lakey.repositories.members.BronzeRepository;
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

public class BronzeServiceImpliTest {
@Autowired
    private BronzeRepository repository;
  Bronze bronze;

    private Bronze getSavedClass() {
        List<Bronze> savedGenders = this.repository.findAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.bronze =repository.save(BronzeMemberFactory.getClasss(1,"Dillyn", "Lakey")) ;
    }

    @Test
    public void a_create() {
        Bronze created = this.repository.save(this.bronze);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertNotNull(created);
    }

    @Test
    public void b_read() {
        Bronze savedBronze = bronze;
        System.out.println("In read, genderId = "+ savedBronze.getIdBronze());
        Optional<Bronze> read = this.repository.findById(savedBronze.getIdBronze());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertNotNull(read);
    }

    @Test
    public void e_delete() {
        Bronze savedGender = getSavedClass();
        this.repository.deleteById(savedGender.getIdBronze());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive";
        Bronze bronze = new Bronze.Builder().copy(getSavedClass()).name(newName).build();
        System.out.println("In update, about_to_updated = " + bronze);
        Bronze updated = this.repository.save(bronze);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        List<Bronze> all = this.repository.findAll();
        System.out.println("In getAll, all = " + all);

    }
}