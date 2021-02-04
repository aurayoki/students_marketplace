package com.jm.marketplace.service;

import com.jm.marketplace.dao.UserDao;
import com.jm.marketplace.exception.UserEmailExistsException;
import com.jm.marketplace.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> findUserByBirthday(LocalDate date) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email).orElseThrow(() -> new UserEmailExistsException("User have base"));
    }

    @Override
    public boolean checkByEmail(String email) {
        return userDao.findByEmail(email).isPresent();
    }
}
