package com.spocle.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spocle.domain.model.entity.Member;
import com.spocle.domain.repository.MemberRepository;

@Service
@Transactional
public class MemberService {

  @Autowired
  private MemberRepository memberRepository;

  public List<Member> findAll() {
    return memberRepository.findAll();
  }

  public List<Member> findByTeamId(String teamId) {
    return memberRepository.findByTeamId(teamId);
  }

  public Member findOne(String id) {
    return memberRepository.findOne(id);
  }

  public Member create(Member member) {
    return memberRepository.save(member);
  }

  public Member update(Member member) {
    return memberRepository.save(member);
  }

  public void delete(String id) {
    memberRepository.delete(id);
  }
}
