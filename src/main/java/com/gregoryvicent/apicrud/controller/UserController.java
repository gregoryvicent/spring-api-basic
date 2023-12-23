package com.gregoryvicent.apicrud.controller;

import com.gregoryvicent.apicrud.db.UserDB;
import com.gregoryvicent.apicrud.model.OneUserResponse;
import com.gregoryvicent.apicrud.model.User;
import com.gregoryvicent.apicrud.model.UsersResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {
    UserDB userDB = new UserDB();
    private final AtomicLong autoIncrementID = new AtomicLong();


    @GetMapping(path = "/everyone")
    public UsersResponse getAllUsers() {
        return userDB.getUsersList();
    }

    @GetMapping(path = "/get/{id}")
    public OneUserResponse getOneUser(@PathVariable Long id) {
        return userDB.getOneUser(id);
    }

    @PostMapping(path = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public OneUserResponse createUser(@RequestBody User userData) {
        User user = new User();

        user.setId(autoIncrementID.incrementAndGet());
        user.setFirstName(userData.getFirstName());
        user.setLastName(userData.getLastName());
        user.setPassword(userData.getPassword());
        user.setEmail(userData.getEmail());

        return userDB.createUser(user);
    }

    @PutMapping(path = "/update/{id}")
    public OneUserResponse updateUser(@PathVariable Long id, @RequestBody User userData) {
        return userDB.updateUser(id, userData);
    }

    @DeleteMapping(path = "/delete/{id}")
    public OneUserResponse deleteUser(@PathVariable Long id) {
        return userDB.deleteUser(id);
    }
}
