package com.flaviodev.events.repo;

import org.springframework.data.repository.CrudRepository;

import com.flaviodev.events.model.Event;

public interface EventRepo extends CrudRepository<Event, Integer>{
  public Event findByPrettyName(String prettyName);
}
