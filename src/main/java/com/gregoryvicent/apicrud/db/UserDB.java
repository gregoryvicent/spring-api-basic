package com.gregoryvicent.apicrud.db;

import com.gregoryvicent.apicrud.model.OneUserResponse;
import com.gregoryvicent.apicrud.model.User;
import com.gregoryvicent.apicrud.model.UsersResponse;

import java.util.ArrayList;

public class UserDB {
    ArrayList<User> usersList = new ArrayList<>();

    public UsersResponse getUsersList() {
        return new UsersResponse(200, usersList);
    }

    public OneUserResponse getOneUser(Long findId) {
        for (User user : usersList) {
            if (user.getId().equals(findId)) {
                return new OneUserResponse(200, user);
            }
        }

        return new OneUserResponse(404, null);
    }

    public OneUserResponse createUser(User user) {
        this.usersList.add(user);

        return new OneUserResponse(201, user);
    }

    public OneUserResponse deleteUser(Long findId) {
        for (User user : usersList) {
            if (user.getId().equals(findId)) {
                this.usersList.remove(user);
                return new OneUserResponse(200,  user);
            }
        }

        return new OneUserResponse(404,  null);
    }

    public OneUserResponse updateUser(Long findId, User userData) {
        for (User user : usersList) {
            if (user.getId().equals(findId)) {
                user.setFirstName(userData.getFirstName());
                user.setLastName(userData.getLastName());
                user.setEmail(userData.getEmail());
                user.setPassword(userData.getPassword());

                return new OneUserResponse(200, user);
            }
        }

        return new OneUserResponse(404, null);
    }
}
