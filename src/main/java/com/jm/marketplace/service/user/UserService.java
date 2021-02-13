package com.jm.marketplace.service.user;

import com.jm.marketplace.dto.UserDto;
import com.jm.marketplace.model.user.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface UserService extends UserDetailsService {

    void saveUser (UserDto userDto);

    List<User> findUserByBirthday(LocalDate date);

    List<UserDto> findAll();

    UserDto findById(Long id);

    void deleteById(Long id);

    User findByEmail(String email);

    boolean checkByEmail(String email);

    User findByPhone(String phone);

    /**
     *
     * @param email для аутентификации
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
}
