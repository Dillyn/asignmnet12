package com.cput.lakey.services.Impli;

import com.cput.lakey.App;
import com.cput.lakey.domain.members.Member;
import com.cput.lakey.factories.members.MemberFactory;
import com.cput.lakey.repositories.members.MemberRepository;
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

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@DataJpaTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration(classes = App.class)

public class MemberServiceImpliTest {
    @Autowired
    public MemberRepository repository;
    public Member member;

    private Member getSavedClass() {
        List<Member> savedGenders = this.repository.findAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.member = repository.save(MemberFactory.getClasss(1,"Dillyn", "Lakey"));
    }

    @Test
    public void a_create() {
        Member created = repository.save(member);
        System.out.println("In create, created = " + created);
        //d_getAll();
        Assert.assertNotNull(created);
    }
    @Test
    public void b_read() {
       Optional<Member> savedMember = repository.findById(1);
        System.out.println("In read, genderId = "+ repository.findById(1));
       Optional <Member> read = this.repository.findById(1);
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedMember, read);
    }



    @Test
    public void c_update() {
        String newName = "Explosive";
        Member member = MemberFactory.getClasss(1,newName, "Lakey");
        System.out.println("In update, about_to_updated = " + member);
        Member updated = this.repository.save(member);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        List<Member> all = this.repository.findAll();
        System.out.println("In getAll, all = " + all);

    }

    @Test
    public void e_delete() {
        Member savedGender = this.member;
        System.out.println("In getAll, all = " +savedGender.getIdMember());
        this.repository.deleteById(savedGender.getIdMember());
        d_getAll();
    }
}