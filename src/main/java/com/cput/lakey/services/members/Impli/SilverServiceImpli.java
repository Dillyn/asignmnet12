package com.cput.lakey.services.members.Impli;

import com.cput.lakey.domain.members.Silver;
import com.cput.lakey.repositories.members.SilverRepository;
import com.cput.lakey.services.members.SilverService;

import java.util.List;
import java.util.Optional;

public class SilverServiceImpli implements SilverService {

    private SilverRepository memberRepository;
    private static SilverService memberService = null;

    private SilverServiceImpli() {
    }

    public SilverService getSilverService() {
        if (memberService == null) memberService = new SilverServiceImpli();
        return memberService;
    }

    @Override
    public Silver create(Silver d) {
        return this.memberRepository.save(d);
    }

    @Override
    public Silver read(Integer strengthId) {
        Optional<Silver> optGender = this.memberRepository.findById(strengthId);
        return optGender.orElse(null);    }

    @Override
    public Silver update(Silver strength) {
        return this.memberRepository.save(strength);
    }

    @Override
    public void delete(Integer strengthId) {
        this.memberRepository.deleteById(strengthId);
    }

    @Override
    public List<Silver> getAll() { return this.memberRepository.findAll();
    }
}
