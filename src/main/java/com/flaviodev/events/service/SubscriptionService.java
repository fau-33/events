package com.flaviodev.events.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flaviodev.events.dto.SubscriptionConflictException;
import com.flaviodev.events.dto.SubscriptionRankingItem;
import com.flaviodev.events.dto.SubscriptionResponse;
import com.flaviodev.events.exception.EventNotFoundException;
import com.flaviodev.events.exception.UserIndicadorNotFoundException;
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
  
  public SubscriptionResponse createNewSubscription(String eventName, User user, Integer userId){
    // busca o evento pelo nome
    Event evt = evtRepo.findByPrettyName(eventName);
    if(evt == null){ // Caso alternativo 2
      throw new EventNotFoundException("Evento " + eventName + " não existe");
    }
    User userRec = userRepo.findByEmail(user.getEmail());
    if(userRec == null){ // Caso alternativo 1
      userRec = userRepo.save(user);
    }
    User indicador = null;
    if(userId != null){
      indicador = userRepo.findById(userId).orElse(null);
    if(indicador == null){
      throw new UserIndicadorNotFoundException("Usuário " + userId + " indicador não existe");
    }
  }

    Subscription subs = new Subscription();
    subs.setEvent(evt);
    subs.setSubscriber(userRec);
    subs.setIndication(indicador);

    Subscription tmpSub = subRepo.findByEventAndSubscriber(evt, userRec);
    if(tmpSub != null){ // Caso alternativo 3
      throw new SubscriptionConflictException("Já existe inscrição para o usuário " + userRec.getName() + " no evento " + evt.getTitle());
    }

    Subscription res = subRepo.save(subs);

    return new SubscriptionResponse(res.getSubscriptionNumber(), "http://codecraft.com/subscription/" + res.getEvent().getPrettyName()+ "/" + res.getSubscriber().getId());
  }

  public List<SubscriptionRankingItem> getCompleteRanking(String prettyName) {
    Event evt = evtRepo.findByPrettyName(prettyName);
    if(evt == null){
      throw new EventNotFoundException("Ranking do evento " + prettyName + " não existe.");
    }
    return subRepo.generateRanking(evt.getEventId());

  }
}
