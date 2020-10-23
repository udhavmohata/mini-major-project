package com.uv.trial.Recommendation.Exception;

public class InvalidCategoryException extends RuntimeException
{
    public InvalidCategoryException()
    {
        super("Entered Category Not Found. Enter a valid Category");
    }
}
