package com.cput.lakey.repositories.staff.impli;

import com.cput.lakey.App;
import com.cput.lakey.domain.staff.Staff;
import com.cput.lakey.factories.staff.StaffFactory;
import com.cput.lakey.repositories.staff.StaffRepository;
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
public class StaffRepositoryImpliTest {
    @Autowired
    private StaffRepository repository;
    private Staff staff;

    private Staff getSavedClass() {
        List<Staff> savedGenders = this.repository.findAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        //    Date date = new Date();
        this.staff = repository.save(StaffFactory.getStaff(1, "Dillyn", "Lakey", "Boss"));
    }

    @Test
    public void a_create() {
        Staff created = this.repository.save(this.staff);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.staff);
    }

    @Test
    public void b_read() {
        Staff savedStaff = getSavedClass();
        System.out.println("In read, genderId = " + savedStaff.getIdStaff());
        Optional<Staff> read = this.repository.findById(savedStaff.getIdStaff());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertNotNull(read);
    }

    @Test
    public void e_delete() {
        Staff savedGender = getSavedClass();
        this.repository.deleteById(savedGender.getIdStaff());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newName = "Explosive";
        Staff staff = new Staff.Builder().copy(getSavedClass()).name(newName).build();
        System.out.println("In update, about_to_updated = " + staff);
        Staff updated = this.repository.save(staff);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        List<Staff> all = this.repository.findAll();
        System.out.println("In getAll, all = " + all);

    }
}