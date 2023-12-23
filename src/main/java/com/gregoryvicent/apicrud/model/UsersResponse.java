package com.gregoryvicent.apicrud.model;

public class UsersResponse extends Response {
    Iterable<User> usersList;

    public UsersResponse(Integer statusCode, Iterable<User> usersList) {
        super(statusCode);
        this.usersList = usersList;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public Iterable<User> getUsersList() {
        return this.usersList;
    }
}
