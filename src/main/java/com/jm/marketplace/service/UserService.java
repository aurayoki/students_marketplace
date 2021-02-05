package com.jm.marketplace.service;

import com.jm.marketplace.models.user.User;

import java.time.LocalDate;
import java.util.List;

public interface UserService {

    void saveUser (User user);

    List<User> findUserByBirthday(LocalDate date);

    List<User> findAll();

    User findByEmail(String email);

    boolean checkByEmail(String email);

    User findByPhone(String phone);
}
