package com.cput.lakey.services.members;

import com.cput.lakey.domain.members.Member;
import com.cput.lakey.services.IServices;

import java.util.List;

public interface MemberService extends IServices<Member, Integer> {
    List<Member> getAll();
    void deleteAll();
}
