package com.flaviodev.events.controller;

import java.util.logging.ErrorManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flaviodev.events.dto.ErrorMessage;
import com.flaviodev.events.exception.EventNotFoundException;
import com.flaviodev.events.model.Subscription;
import com.flaviodev.events.model.User;
import com.flaviodev.events.service.SubscriptionService;



@RestController
public class SubscriptionController {

  @Autowired
  private SubscriptionService service;

  @PostMapping("/subscription/{prettyName}")
  public ResponseEntity<?> createSubscription(@PathVariable String prettyName, @RequestBody User subscriber){
    try{
    Subscription res = service.createNewSubscription(prettyName, subscriber);
    if(res != null){
      return ResponseEntity.ok(res);
    }
    
  }catch(EventNotFoundException ex){
    return ResponseEntity.status(404).body( new ErrorMessage(ex.getMessage()));
  }
  return ResponseEntity.badRequest().build();
}}
