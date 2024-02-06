package com.demo.Students.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class ResourseNotFoundExceptoin extends RuntimeException{
    public ResourseNotFoundExceptoin(String msg){
        super(msg);
    }
}
