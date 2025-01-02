package com.example.EventCenter.Controller;
import com.example.EventCenter.Dto.EventDetailsDto;
import com.example.EventCenter.Entity.Event;
import com.example.EventCenter.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }

    @PostMapping("/create")
    public ResponseEntity<Event> createEvent(@RequestBody EventDetailsDto eventDetailsDto) {
        Event event = eventService.createEvent(eventDetailsDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(event);
    }
}
