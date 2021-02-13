package com.jm.marketplace.service.user;

import com.jm.marketplace.config.mapper.MapperFacade;
import com.jm.marketplace.dao.UserDao;
import com.jm.marketplace.dto.UserDto;
import com.jm.marketplace.exception.UserEmailExistsException;
import com.jm.marketplace.exception.UserNotFoundException;
import com.jm.marketplace.exception.UserPhoneExistsException;
import com.jm.marketplace.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public UserServiceImpl(UserDao userDao, MapperFacade mapperFacade) {
        this.userDao = userDao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional
    public void saveUser(UserDto userDto) {
        userDao.save(mapperFacade.map(userDto, User.class));
    }

    @Transactional(readOnly = true)
    @Override
    public UserDto findById(Long id) {
        User user = userDao.findById(id).orElseThrow(() ->
                new UserNotFoundException(String.format("User not found by id: %s", id)));
        return mapperFacade.map(user, UserDto.class);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findUserByBirthday(LocalDate date) {
        return userDao.findUserByBirthday(date);
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserDto> findAll() {
        return mapperFacade.mapAsList(userDao.findAll(), UserDto.class);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
      userDao.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email).orElseThrow(() -> new UserEmailExistsException("Пользователь с такой почтой не найден"));
    }

    @Transactional(readOnly = true)
    @Override
    public boolean checkByEmail(String email) {
        return userDao.findByEmail(email).isPresent();
    }

    @Transactional(readOnly = true)
    @Override
    public User findByPhone(String phone) {
        return userDao.findByPhone(phone).orElseThrow(() -> new UserPhoneExistsException("Пользователь с таким номером телефона не найден"));
    }
}
