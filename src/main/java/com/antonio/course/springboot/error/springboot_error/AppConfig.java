package com.antonio.course.springboot.error.springboot_error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.antonio.course.springboot.error.springboot_error.models.domain.User;

@Configuration
public class AppConfig {

  @Bean
  List<User> users() {
    List<User> users = new ArrayList<User>();
    users.add(new User(1L, "Antonio", "Banderas"));
    users.add(new User(2L, "John", "Doe"));
    users.add(new User(3L, "Michael", "Jackson"));
    return users;
  }

}
