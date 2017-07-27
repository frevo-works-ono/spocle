package com.spocle.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spocle.domain.model.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
  public List<Member> findByTeamId(String teamId);
}
