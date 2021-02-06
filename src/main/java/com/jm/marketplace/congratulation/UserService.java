package com.jm.marketplace.congratulation;

import com.jm.marketplace.congratulation.model.user.User;

import java.time.LocalDate;
import java.util.List;

public interface UserService {
    List<User> findUserByBirthday(LocalDate localDate);
}
