package com.example.EventCenter.Service;

import com.example.EventCenter.Dto.EventDetailsDto;
import com.example.EventCenter.Entity.Category;
import com.example.EventCenter.Entity.Event;
import com.example.EventCenter.Repository.CategoryRepository;
import com.example.EventCenter.Repository.EventRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }


    public Event createEvent(EventDetailsDto eventDetailsDto) {
        // Yeni bir Event nesnesi oluştur
        Event event = new Event();
        event.setTitle(eventDetailsDto.getTitle());
        event.setDescription(eventDetailsDto.getDescription());
        event.setLocation(eventDetailsDto.getLocation());
        event.setEventDate(eventDetailsDto.getEventDate());
        event.setStatus(eventDetailsDto.getStatus());
        event.setMaxCapacity(eventDetailsDto.getMaxCapacity());
        event.setMinAge(eventDetailsDto.getMinAge());
        event.setCreatedAt(LocalDateTime.now());
        event.setCategoryName(eventDetailsDto.getCategoryName());

        // Kategori ismini al
        String categoryName = eventDetailsDto.getCategoryName();


        // Kategori ismini kullanarak Category nesnesini bul
        Category category = categoryRepository.findByName(categoryName)
                .orElseThrow(() -> new RuntimeException("Kategori bulunamadı: " + categoryName));

        // Event nesnesine kategori ekle
        event.getEvent_categories().add(category);

        // Event'i kaydet
        return eventRepository.save(event);
    }

}




