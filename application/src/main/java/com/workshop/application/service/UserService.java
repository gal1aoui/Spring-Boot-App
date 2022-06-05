package com.workshop.application.service;

import java.util.Set;

import com.workshop.application.model.User;

public interface UserService {
    User create(User user);
    Set<User> list(int limit);
    User getUser(Long id);
    User update(User user);
    Boolean delete(Long id);
}
