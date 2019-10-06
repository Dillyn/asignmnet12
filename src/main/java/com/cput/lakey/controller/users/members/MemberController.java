package com.cput.lakey.controller.users.members;

import com.cput.lakey.domain.members.Member;
import com.cput.lakey.services.members.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
@RestController
@RequestMapping("/api/member")
public class MemberController {
    @Autowired
    @Qualifier("memberServiceImpli")
    private MemberService service;

    @PostMapping(value ="/create" , produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Member create(@RequestBody Member member) {
        return service.create(member);
    }

    @PostMapping("/update")
    @ResponseBody
    public Member update(Member member) {
        return service.update(member);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @DeleteMapping("/delete/all")
    @ResponseBody
    public void deleteAll() {
        service.deleteAll();
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Member read(@PathVariable Integer id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public List<Member> getAll() {
        return service.getAll();
    }
}
