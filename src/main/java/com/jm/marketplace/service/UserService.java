package com.jm.marketplace.service;

import com.jm.marketplace.model.User;

import java.time.LocalDate;
import java.util.List;

public interface UserService {

    void saveUser (User user);

    List<User> findUserByBirthday(LocalDate date);

    User findByEmail(String email);

    boolean checkByEmail(String email);
}
