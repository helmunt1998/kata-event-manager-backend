package com.bancodebogota.eventmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
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
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:8081"})
public class EventController {
	
	@Autowired
    private IEventService eventService;

    @GetMapping("/events")
    public ResponseEntity<List<Event>> getEvents() {
        SecurityContextHolder.getContext().getAuthentication();
        if(eventService.findAllEvents().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(eventService.findAllEvents(), HttpStatus.OK);
        }
    }

    @GetMapping("/event/{id}")
    public  ResponseEntity<Event> getEvent(@PathVariable("id") Long id) throws IllegalArgumentException {
        SecurityContextHolder.getContext().getAuthentication();
        if(eventService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else{
            return new ResponseEntity<>(eventService.findById(id), HttpStatus.OK);
        }
    }

    @PostMapping("/event")
    public void createEvent(@RequestBody Event event) {
        SecurityContextHolder.getContext().getAuthentication();
        eventService.createEvent(event);
    }
    
    @PutMapping("/event/{id}")
    public ResponseEntity<String> updateEvent(@RequestBody Event event, @PathVariable("id") Long id) throws IllegalArgumentException {
        SecurityContextHolder.getContext().getAuthentication();
        try {
            eventService.updateEvent(event, id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        
    }
    
    @DeleteMapping("/event/{id}")
    public void deleteEvent(@PathVariable("id") Long id) {
        SecurityContextHolder.getContext().getAuthentication();
        eventService.deleteEvent(id);
    }

}
