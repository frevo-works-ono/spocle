package com.spocle.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spocle.domain.model.entity.Event;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, String> {
    public List<Event> findByTeamId(String teamId);
}
