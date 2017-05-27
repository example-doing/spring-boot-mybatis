package com.zg.web;

import com.zg.result.HttpCodeEnum;
import com.zg.result.ResponseView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseView handleException(MethodArgumentTypeMismatchException e) {
        e.printStackTrace();
        return new ResponseView<>(HttpCodeEnum.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseView handleException(Exception e) {
        e.printStackTrace();
        return new ResponseView<>(HttpCodeEnum.BAD_REQUEST);
    }
}
