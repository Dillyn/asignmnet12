package com.cput.lakey.services.members.Impli;

import com.cput.lakey.domain.members.Bronze;
import com.cput.lakey.repositories.members.BronzeRepository;
import com.cput.lakey.services.members.BronzeService;

import java.util.List;
import java.util.Optional;

public class BronzeServiceImpli implements BronzeService {

    private BronzeRepository memberRepository;
    private static BronzeService memberService = null;

    private BronzeServiceImpli() {
    }

    public BronzeService getBronzeService() {
        if (memberService == null) memberService = new BronzeServiceImpli();
        return memberService;
    }

    @Override
    public Bronze create(Bronze d) {
        return this.memberRepository.save(d);
    }

    @Override
    public Bronze read(Integer strengthId) {
        Optional<Bronze> optGender = this.memberRepository.findById(strengthId);
        return optGender.orElse(null);
    }

    @Override
    public Bronze update(Bronze strength) {
        return this.memberRepository.save(strength);
    }

    @Override
    public void delete(Integer strengthId) {
        this.memberRepository.deleteById(strengthId);
    }

    @Override
    public List<Bronze> getAll() { return this.memberRepository.findAll();
    }
}