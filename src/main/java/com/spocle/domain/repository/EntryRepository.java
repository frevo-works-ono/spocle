package com.spocle.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spocle.domain.model.entity.Entry;

public interface EntryRepository extends JpaRepository<Entry, Long> {
}
