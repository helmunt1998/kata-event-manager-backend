package com.bancodebogota.eventmanager.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancodebogota.eventmanager.entity.Event;
import com.bancodebogota.eventmanager.repository.EventRepository;

@Service
public class EventServiceImp implements IEventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public void createEvent(Event event) {
        eventRepository.save(event);
    }

    @Override
    public void updateEvent(Event event, Long id) {
        Event eventToUpdate = eventRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        if(Objects.nonNull(event.getName())) {
            eventToUpdate.setName(event.getName());
        }
        if(Objects.nonNull(event.getDate())) {
            eventToUpdate.setDate(event.getDate());
        }
        if(Objects.nonNull(event.getTime())) {
            eventToUpdate.setTime(event.getTime());
        }
        if(Objects.nonNull(event.getLocation())) {
            eventToUpdate.setLocation(event.getLocation());
        }
        if(Objects.nonNull(event.getDescription())) {
            eventToUpdate.setDescription(event.getDescription());
        }
        eventRepository.save(eventToUpdate);
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public Event findById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    @Override
    public List<Event> findAllEvents() {
        return eventRepository.findAll();
    }

}
