package com.jm.marketplace.service.user;

import com.jm.marketplace.dao.UserDao;
import com.jm.marketplace.dto.CityDto;
import com.jm.marketplace.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserDao userDaoMock;

    UserDto userDto = new UserDto(1L, "Tommy", "Garposs", "1234", "asd@gmail.com",
            new CityDto(1L, "Piter"), LocalDate.of(1992, 6, 2),
            "89679681234", "null", null, null);

    @Test
    void findAll() {
    }

    @Test
    void saveUser() {
    }

    @Test
    void findById() {
    }

    @Test
    void findUserByBirthday() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findByEmail() {
    }

    @Test
    void checkByEmail() {
    }

    @Test
    void findByPhone() {
    }
}

