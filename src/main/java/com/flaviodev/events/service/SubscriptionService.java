package com.flaviodev.events.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flaviodev.events.exception.EventNotFoundException;
import com.flaviodev.events.model.Event;
import com.flaviodev.events.model.Subscription;
import com.flaviodev.events.model.User;
import com.flaviodev.events.repo.EventRepo;
import com.flaviodev.events.repo.SubscriptionRepo;
import com.flaviodev.events.repo.UserRepo;

@Service
public class SubscriptionService {

  @Autowired
  private EventRepo evtRepo;

  @Autowired
  private UserRepo userRepo;

  @Autowired
  private SubscriptionRepo subRepo;
  
  public Subscription createNewSubscription(String eventName, User user){
    // busca o evento pelo nome
    Event evt = evtRepo.findByPrettyName(eventName);
    if(evt == null){
      throw new EventNotFoundException("Evento " + eventName + " não existe");
    }
    User userRec = userRepo.findByEmail(user.getEmail());
    if(userRec == null){
      userRec = userRepo.save(user);
    }

    Subscription subs = new Subscription();
    subs.setEvent(evt);
    subs.setSubscriber(userRec);

    Subscription res = subRepo.save(subs);

    return res;
  }
}
