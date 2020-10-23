package com.uv.trial.Recommendation.Exception;

public class InvalidGenderException extends RuntimeException
{
    public InvalidGenderException()
    {
        super("Enter a valid Gender");
    }
}
