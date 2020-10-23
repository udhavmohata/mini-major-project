package com.uv.trial.Recommendation.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler
{
    @ExceptionHandler({InvalidInputException.class,InvalidGenderException.class,NotUniqueException.class})
    public void BadRequest(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler({InvalidCategoryException.class,InvalidBrandException.class,DataNotFoundException.class})
    public void NotFound(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(InvalidUserException.class)
    public void InvalidUser(HttpServletResponse response) throws IOException
    {
        response.sendError(HttpStatus.UNAUTHORIZED.value());
    }
}
