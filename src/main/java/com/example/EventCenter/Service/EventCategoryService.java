package com.example.EventCenter.Service;

import com.example.EventCenter.Entity.EventCategory;
import com.example.EventCenter.Repository.EventCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventCategoryService {

    @Autowired
    private EventCategoryRepository eventCategoryRepository;

    public List<EventCategory> getAllEventCategories() {
        return eventCategoryRepository.findAll();
    }

    public EventCategory getEventCategoryById(Long id) {
        return eventCategoryRepository.findById(id).orElse(null);
    }

    public EventCategory createEventCategory(EventCategory eventCategory) {
        return eventCategoryRepository.save(eventCategory);
    }

    public EventCategory updateEventCategory(Long id, EventCategory eventCategoryDetails) {
        EventCategory eventCategory = eventCategoryRepository.findById(id).orElse(null);
        if (eventCategory != null) {
            eventCategory.setName(eventCategoryDetails.getName());
            eventCategory.setDescription(eventCategoryDetails.getDescription());
            return eventCategoryRepository.save(eventCategory);
        }
        return null;
    }

    public void deleteEventCategory(Long id) {
        eventCategoryRepository.deleteById(id);
    }
}

