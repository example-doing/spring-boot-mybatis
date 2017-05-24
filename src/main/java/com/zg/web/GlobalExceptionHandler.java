package com.zg.web;

import com.zg.result.ResponseCodeEnum;
import com.zg.result.ResponseView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseView handleException(Exception ex) {
        logger.error(ex.toString());
        return new ResponseView<>(ResponseCodeEnum.INTERNAL_SERVER_ERROR, null);
    }
}
