package com.gregoryvicent.apicrud.model;

public class OneUserResponse extends Response {
    User user;

    public OneUserResponse(Integer statusCode, User user) {
        super(statusCode);
        this.user = user;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public User getUser() {
        return this.user;
    }
}
