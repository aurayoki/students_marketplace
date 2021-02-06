package com.jm.marketplace.service.user;

import com.jm.marketplace.config.mapper.MapperFacade;
import com.jm.marketplace.dto.UserDto;
import com.jm.marketplace.model.user.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface UserService {

    void saveUser (User user);

    List<User> findUserByBirthday(LocalDate date);

    List<UserDto> findAll();

    UserDto findById(Long id);

    void deleteById(Long id);

    User findByEmail(String email);

    boolean checkByEmail(String email);

    User findByPhone(String phone);
}
