package com.uv.trial.Recommendation.Exception;

public class InvalidUserException extends RuntimeException
{
    public InvalidUserException() {
        super("Invalid username and password");
    }
}
