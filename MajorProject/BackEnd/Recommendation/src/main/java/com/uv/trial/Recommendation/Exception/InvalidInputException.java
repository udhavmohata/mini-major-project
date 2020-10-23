package com.uv.trial.Recommendation.Exception;


public class InvalidInputException extends RuntimeException
{
    public InvalidInputException()
    {
        super("Invalid Input");
    }
    public InvalidInputException(String s)
    {
        super("Invalid "+s);
    }
}
