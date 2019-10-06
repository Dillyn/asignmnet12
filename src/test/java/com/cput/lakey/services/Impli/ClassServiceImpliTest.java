package com.cput.lakey.services.Impli;

import com.cput.lakey.App;
import com.cput.lakey.domain.classes.Classs;
import com.cput.lakey.factories.classes.ClasssFactory;
import com.cput.lakey.repositories.classes.ClassRepository;
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

public class ClassServiceImpliTest {
    @Autowired
    private ClassRepository repository;
    private Classs classs;

    private Classs getSavedClass() {
        List<Classs> savedGenders = this.repository.findAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.classs = this.repository.save(ClasssFactory.getClasss(1,"Spinning"));
    }

    @Test
    public void a_create() {
        Classs created = this.repository.save(this.classs);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.classs);
    }

    @Test
    public void b_read() {
        Classs savedClasss = getSavedClass();
        System.out.println("In read, genderId = "+ savedClasss.getIdClass());
       Optional<Classs> read = this.repository.findById(savedClasss.getIdClass());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertNotNull(savedClasss.getName());
    }

    @Test
    public void e_delete() {
        Classs savedGender = getSavedClass();
        this.repository.existsById(1);
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive";
        Classs classs = new Classs.Builder().copy(getSavedClass()).name(newName).build();
        System.out.println("In update, about_to_updated = " + classs);
        Classs updated = this.repository.save(classs);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        List<Classs> all = this.repository.findAll();
        System.out.println("In getAll, all = " + all);

    }
}