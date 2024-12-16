package com.code.graphql.exception;

public class ExceptionHelper{

    public static RuntimeException throwResourceNotFountException(){
        return new RuntimeException("Resource Not Found");
    }
}
