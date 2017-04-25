package com.spocle.domain.service;

import com.spocle.domain.model.entity.Entry;
import com.spocle.domain.model.entity.Event;
import com.spocle.domain.repository.EntryRepository;
import com.spocle.domain.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by h.ono on 2017/04/08.
 */
@Service
@Transactional
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

     public List<Event> findByTeamId(Long teamId) {
        return eventRepository.findByTeamId(teamId);
     }

    public Event findOne(Long id) {

        return eventRepository.findOne(id);
    }

    public Event create(Event member) {

        return eventRepository.save(member);
    }

    public Event update(Event member) {
        return eventRepository.save(member);
    }

    public void delete(Long id) {

        eventRepository.delete(id);
    }
}
