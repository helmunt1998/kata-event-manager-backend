package com.bancodebogota.eventmanager.service;

import java.util.List;

import com.bancodebogota.eventmanager.entity.Event;

public interface IEventService {

    public void createEvent(Event event);
    public void updateEvent(Event event, Long id);
    public void deleteEvent(Long id);
    public Event findById(Long id);
    public List<Event> findAllEvents();

}
