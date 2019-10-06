package com.cput.lakey.services.Impli;

import com.cput.lakey.App;
import com.cput.lakey.domain.members.Silver;
import com.cput.lakey.factories.members.SilverMemberFactory;
import com.cput.lakey.repositories.members.SilverRepository;
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

public class SilverServiceImpliTest {
    @Autowired
    private SilverRepository repository;
    private Silver silver;

    private Silver getSavedClass() {
        List<Silver> savedGenders = this.repository.findAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.silver = repository.save(SilverMemberFactory.getClasss(1, "Dillyn", "Lakey"));
    }

    @Test
    public void a_create() {
        Silver created = this.repository.save(this.silver);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.silver);
    }

    @Test
    public void b_read() {
        Silver savedSilver = getSavedClass();
        System.out.println("In read, genderId = " + savedSilver.getIdSilver());
        Optional<Silver> read = this.repository.findById(savedSilver.getIdSilver());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertNotNull( read);
    }

    @Test
    public void e_delete() {
        Silver savedGender = getSavedClass();
        this.repository.deleteById(savedGender.getIdSilver());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive";
        Silver silver = new Silver.Builder().copy(getSavedClass()).name(newName).build();
        System.out.println("In update, about_to_updated = " + silver);
        Silver updated = this.repository.save(silver);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        List<Silver> all = this.repository.findAll();
        System.out.println("In getAll, all = " + all);

    }
}