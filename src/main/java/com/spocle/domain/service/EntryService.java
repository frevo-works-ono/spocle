package com.spocle.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spocle.domain.model.entity.Entry;
import com.spocle.domain.repository.EntryRepository;

@Service
@Transactional
public class EntryService {

  @Autowired
  private EntryRepository entryRepository;

  public List<Entry> findAll() {
    return entryRepository.findAll();
  }

  // public List<Entry> findByTeamId(Long teamId) {
  // return entryRepository.findByTeamId(teamId);
  // }

  public Entry findOne(Long id) {
    return entryRepository.findOne(id);
  }

  public Entry create(Entry member) {
    return entryRepository.save(member);
  }

  public Entry update(Entry member) {
    return entryRepository.save(member);
  }

  public void delete(Long id) {
    entryRepository.delete(id);
  }
}
