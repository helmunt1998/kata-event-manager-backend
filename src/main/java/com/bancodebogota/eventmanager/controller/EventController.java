package com.bancodebogota.eventmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancodebogota.eventmanager.entity.Event;
import com.bancodebogota.eventmanager.service.IEventService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/event-manager")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:8081"})
public class EventController {
	
	@Autowired
    private IEventService eventService;

    @GetMapping("/events")
    public List<Event> getEvents() {
        return eventService.findAllEvents();
    }

    @GetMapping("/event/{id}")
    public Event getEvent(@PathVariable("id") Long id) {
        return eventService.findById(id);
    }

    @PostMapping("/event")
    public void createEvent(@RequestBody Event event) {
        eventService.createEvent(event);
    }
    
    @PutMapping("/event/{id}")
    public void updateEvent(@RequestBody Event event, @PathVariable("id") Long id) {
        eventService.updateEvent(event, id);
    }
    
    @DeleteMapping("/event/{id}")
    public void deleteEvent(@PathVariable("id") Long id) {
        eventService.deleteEvent(id);
    }

}
