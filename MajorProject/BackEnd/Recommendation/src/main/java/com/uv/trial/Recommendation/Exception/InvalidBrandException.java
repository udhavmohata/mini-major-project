package com.uv.trial.Recommendation.Exception;

public class InvalidBrandException extends RuntimeException
{
    public InvalidBrandException(String s)
    {
        super(s+" Not Found");
    }

}
