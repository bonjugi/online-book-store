package com.book.member.service;

import com.book.member.domain.Email;
import com.book.member.domain.Member;
import com.book.member.exception.MemberDuplicationException;
import com.book.member.exception.MemberNotFoundException;
import com.book.member.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberHelperService {

    private final MemberRepository memberRepository;

    public Member findById(final long id){
        final Optional<Member> member = memberRepository.findById(id);
        member.orElseThrow(() -> new MemberNotFoundException());
        return member.get();
    }

    public void verifyEmailIsDuplicated(final Email email){
        if(isEmailDuplicated(email)) throw new MemberDuplicationException();
    }

    public List<Member> findByAll() {
        return memberRepository.findAll();
    }

    private boolean isEmailDuplicated(final Email email){
        return memberRepository.findByEmail(email) != null;
    }

}
