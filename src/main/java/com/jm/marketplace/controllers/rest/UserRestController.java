package com.jm.marketplace.controllers.rest;

import com.jm.marketplace.model.user.User;
import com.jm.marketplace.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public List<User> showAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable Long id) {
        return userService.findById(id);
    }

/*    @PostMapping()
    public User addNewUser(@RequestBody User user) {
        userService.saveUser(user);
    }*/

/*    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        userService.update(user.getId(), user);
        return user;
    }*/

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {

        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(id);

        userService.deleteInBatch((ArrayList<User>) userService.findAllById(arrayList));
        return "User with ID = " + id + " was deleted";
    }

}
