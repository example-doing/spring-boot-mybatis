package com.zg.web;

import com.zg.result.ResponseCodeEnum;
import com.zg.result.ResponseView;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalErrorController implements ErrorController {
    @RequestMapping
    public ResponseView handleError() {
        return new ResponseView<>(ResponseCodeEnum.NOT_FOUND, null);
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
