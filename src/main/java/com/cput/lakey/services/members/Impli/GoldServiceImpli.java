package com.cput.lakey.services.members.Impli;

import com.cput.lakey.domain.members.Gold;
import com.cput.lakey.repositories.members.GoldRepository;
import com.cput.lakey.services.members.GoldService;

import java.util.List;
import java.util.Optional;

public class GoldServiceImpli implements GoldService {

    private GoldRepository memberRepository;
    private static GoldService memberService = null;

    private GoldServiceImpli() {
    }

    public GoldService getBronzeService() {
        if (memberService == null) memberService = new GoldServiceImpli();
        return memberService;
    }

    @Override
    public Gold create(Gold d) {
        return this.memberRepository.save(d);
    }

    @Override
    public Gold read(Integer strengthId) {
        Optional<Gold> optGender = this.memberRepository.findById(strengthId);
        return optGender.orElse(null);
    }

    @Override
    public Gold update(Gold strength) {
        return this.memberRepository.save(strength);
    }

    @Override
    public void delete(Integer strengthId) {
        this.memberRepository.deleteById(strengthId);
    }

    @Override
    public List<Gold> getAll() { return this.memberRepository.findAll();
    }
}
