package com.spocle.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spocle.domain.model.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}
