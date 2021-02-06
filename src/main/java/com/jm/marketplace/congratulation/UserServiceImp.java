package com.jm.marketplace.congratulation;

import com.jm.marketplace.congratulation.model.user.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
@Component
public class UserServiceImp implements UserService {
    @Override
    public List<User> findUserByBirthday(LocalDate data) {
        return null;
    }
}
