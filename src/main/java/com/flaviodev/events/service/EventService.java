package com.flaviodev.events.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flaviodev.events.model.Event;
import com.flaviodev.events.repo.EventRepo;

@Service
public class EventService {

  @Autowired
  private EventRepo eventRepo;

  public Event addNewEvent(Event event) {
    // gerando o pretty name
    event.setPrettyName(event.getTitle().toLowerCase().replace(" ", "-"));
    return eventRepo.save(event);
  }

  public List<Event> getAllEvents() {
    return (List<Event>) eventRepo.findAll();
  }

  public Event getByPrettyName(String prettyName) {
    return eventRepo.findByPrettyName(prettyName);
  }
}
