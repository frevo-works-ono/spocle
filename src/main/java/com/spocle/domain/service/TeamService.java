package com.spocle.domain.service;

import com.spocle.domain.model.entity.Member;
import com.spocle.domain.model.entity.Team;
import com.spocle.domain.repository.MemberRepository;
import com.spocle.domain.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeamService {

  @Autowired
  private TeamRepository teamRepository;

  @Autowired
  private StringRedisTemplate redisTemplate;

  public List<Team> findAll() {

    return teamRepository.findAll();
  }

  public Team findOne(String id) {

    return teamRepository.findOne(id);
  }

  public Team create(Team entry) {
    Team newTeam = teamRepository.save(entry);
    redisTemplate.opsForValue().set("1234",String.valueOf(newTeam.getId()));
    return teamRepository.save(entry);
  }

  public Team update(Team entry) {

    return teamRepository.save(entry);
  }

  public void delete(String id) {
    teamRepository.delete(id);
  }
}
