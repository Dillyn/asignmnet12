package com.cput.lakey.services.members.Impli;

import com.cput.lakey.domain.members.Member;
import com.cput.lakey.repositories.members.MemberRepository;
import com.cput.lakey.services.members.MemberService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("memberServiceImpli")
public class MemberServiceImpli implements MemberService {

    private MemberRepository memberRepository;
    private static MemberService memberService = null;

    private MemberServiceImpli() {

    }

    public MemberService getMemberService() {
        if (memberService == null) memberService = new MemberServiceImpli();
        return memberService;
    }

    @Override
    public Member create(Member d) {
        return this.memberRepository.save(d);
    }

    @Override
    public Member read(Integer strengthId) {
        Optional<Member> optGender = this.memberRepository.findById(strengthId);
        return optGender.orElse(null);    }

    @Override
    public Member update(Member strength) {
        return this.memberRepository.save(strength);
    }

    @Override
    public void delete(Integer strengthId) {
        this.memberRepository.deleteById(strengthId);
    }

    @Override
    public void deleteAll(){
        this.memberRepository.deleteAll();
    }

    @Override
    public List<Member> getAll() { return this.memberRepository.findAll();
    }
}

