package com.cput.lakey.services.Impli;

import com.cput.lakey.App;
import com.cput.lakey.domain.members.Gold;
import com.cput.lakey.factories.members.GoldMemberFactory;
import com.cput.lakey.repositories.members.GoldRepository;
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

public class GoldServiceImpliTest {
@Autowired
    private GoldRepository repository;
    private Gold gold;

    private Gold getSavedClass() {
        List<Gold> savedGenders = this.repository.findAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.gold = repository.save(GoldMemberFactory.getClasss(1,"Dillyn", "Lakey"));
    }

    @Test
    public void a_create() {
        Gold created = this.repository.save(GoldMemberFactory.getClasss(1,"Dillyn", "Lakey"));
        List<Gold> golds = this.repository.findAll();
        Assert.assertTrue(!golds.isEmpty());
    }

    @Test
    public void b_read() {
        Gold savedGold = getSavedClass();
        System.out.println("In read, genderId = "+ savedGold.getIdGold());
       Optional<Gold> read = this.repository.findById(savedGold.getIdGold());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertNotNull( read);
    }

    @Test
    public void e_delete() {
        Gold savedGender = getSavedClass();
        this.repository.deleteById(savedGender.getIdGold());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive";
        Gold gold = new Gold.Builder().copy(getSavedClass()).name(newName).build();
        System.out.println("In update, about_to_updated = " + gold);
        Gold updated = this.repository.save(gold);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        List<Gold> all = this.repository.findAll();
        System.out.println("In getAll, all = " + all);

    }
}