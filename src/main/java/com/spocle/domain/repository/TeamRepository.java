package com.spocle.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spocle.domain.model.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
