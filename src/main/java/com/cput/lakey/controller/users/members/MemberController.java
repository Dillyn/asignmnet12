package com.cput.lakey.controller.users.members;

import com.cput.lakey.domain.members.Member;
import com.cput.lakey.repositories.members.MemberRepository;
import com.cput.lakey.services.members.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;
@RestController
@RequestMapping("/api/member")
public class MemberController {
    @Autowired
    @Qualifier("memberServiceImpli")
    private MemberService service;

    @Autowired
    private MemberRepository repository;

    @PostMapping(value ="/create" , produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Member create(@RequestBody Member member) {
        return repository.save(member);
    }

    @PutMapping("/update")
    @ResponseBody
    public Member update(@RequestBody Member member) {
        return repository.save(member);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @DeleteMapping("/delete/all")
    @ResponseBody
    public void deleteAll() {
        repository.deleteAll();
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Member read(@PathVariable Integer id) {

        Optional<Member> optGender = this.repository.findById(id);
        return optGender.orElse(null);     }

    @GetMapping("/read/all")
    @ResponseBody
    public List<Member> getAll() {
        return repository.findAll();
    }
}
