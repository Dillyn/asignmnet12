package com.cput.lakey.services.Impli;

import com.cput.lakey.App;
import com.cput.lakey.domain.staff.HelpDesk;
import com.cput.lakey.factories.staff.HelpDeskFactory;
import com.cput.lakey.repositories.staff.HelpDeskRepository;
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
public class HelpDeskServiceImpliTest {
@Autowired
    private HelpDeskRepository repository;
    private HelpDesk helpDesk;

    private HelpDesk getSavedClass() {
        List<HelpDesk> savedGenders = this.repository.findAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        //    Date date = new Date();
        this.helpDesk = repository.save(HelpDeskFactory.getHelpDesk(1, "Dillyn", "Lakey", "Boss"));
    }

    @Test
    public void a_create() {
        HelpDesk created = this.repository.save(this.helpDesk);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.helpDesk);
    }

    @Test
    public void b_read() {
        HelpDesk savedHelpDesk = getSavedClass();
        System.out.println("In read, genderId = " + savedHelpDesk.getIdHelpDesk());
        Optional<HelpDesk> read = this.repository.findById(savedHelpDesk.getIdHelpDesk());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertNotNull(read);
    }

    @Test
    public void e_delete() {
        HelpDesk savedGender = getSavedClass();
        this.repository.deleteById(savedGender.getIdHelpDesk());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive";
        HelpDesk helpDesk = new HelpDesk.Builder().copy(getSavedClass()).name(newName).build();
        System.out.println("In update, about_to_updated = " + helpDesk);
        HelpDesk updated = this.repository.save(helpDesk);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        List<HelpDesk> all = this.repository.findAll();
        System.out.println("In getAll, all = " + all);

    }
}