package com.antonio.course.springboot.error.springboot_error.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.antonio.course.springboot.error.springboot_error.models.domain.User;

@Service
public class UserServiceImpl implements UserService {

  private List<User> users;

  public UserServiceImpl() {
    this.users = new ArrayList<User>();
    users.add(new User(1L, "Antonio", "Banderas"));
    users.add(new User(2L, "John", "Doe"));
    users.add(new User(3L, "Michael", "Jackson"));
  }

  @Override
  public List<User> findAll() {
    return users;
  }

  @Override
  public User findById(Long id) {
    User user = null;
    for (User u : users) {
      if (u.getId().equals(id)) {
        user = u;
        break;
      }
    }
    return user;
  }

}
