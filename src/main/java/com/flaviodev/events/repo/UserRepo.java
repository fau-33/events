package com.flaviodev.events.repo;

import org.springframework.data.repository.CrudRepository;

import com.flaviodev.events.model.User;

public interface UserRepo extends CrudRepository<User, Integer>  {
  public User findByEmail(String email);
}
