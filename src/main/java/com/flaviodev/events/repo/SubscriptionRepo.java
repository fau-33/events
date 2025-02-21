package com.flaviodev.events.repo;

import org.springframework.data.repository.CrudRepository;

import com.flaviodev.events.model.Subscription;

public interface SubscriptionRepo extends CrudRepository<Subscription, Integer> {

}
