package com.uv.trial.Recommendation.Exception;

public class DataNotFoundException extends RuntimeException
{
    public DataNotFoundException()
    {
        super("Product of this Size Not Available");
    }
}
