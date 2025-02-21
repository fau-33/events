package com.flaviodev.events.repo;

import org.springframework.data.repository.CrudRepository;

import com.flaviodev.events.model.Event;
import com.flaviodev.events.model.Subscription;
import com.flaviodev.events.model.User;

public interface SubscriptionRepo extends CrudRepository<Subscription, Integer> {
  public Subscription findByEventAndSubscriber(Event evt, User user);
}
