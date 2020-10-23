package com.uv.trial.Recommendation.Exception;

public class NotUniqueException extends RuntimeException
{
    public NotUniqueException() {
        super("Entered Mobile Number already Exists");
    }
}
