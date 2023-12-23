package com.gregoryvicent.apicrud.model;

public abstract class Response {
    protected Integer statusCode;

    public Response(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public abstract Integer getStatusCode();
}
