package com.example.EventCenter.Controller;

import com.example.EventCenter.Entity.EventCategory;
import com.example.EventCenter.Service.EventCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/event-categories")
public class EventCategoryController {

    @Autowired
    private EventCategoryService eventCategoryService;

    @GetMapping
    public List<EventCategory> getAllEventCategories() {
        return eventCategoryService.getAllEventCategories();
    }

    @GetMapping("/{id}")
    public EventCategory getEventCategoryById(@PathVariable Long id) {
        return eventCategoryService.getEventCategoryById(id);
    }

    @PostMapping
    public EventCategory createEventCategory(@RequestBody EventCategory eventCategory) {
        return eventCategoryService.createEventCategory(eventCategory);
    }

    @PutMapping("/{id}")
    public EventCategory updateEventCategory(@PathVariable Long id, @RequestBody EventCategory eventCategory) {
        return eventCategoryService.updateEventCategory(id, eventCategory);
    }

    @DeleteMapping("/{id}")
    public void deleteEventCategory(@PathVariable Long id) {
        eventCategoryService.deleteEventCategory(id);
    }
}

