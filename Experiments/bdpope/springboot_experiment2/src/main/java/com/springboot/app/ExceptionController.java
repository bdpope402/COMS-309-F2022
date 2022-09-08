package com.springboot.app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

    @RequestMapping(method = RequestMethod.GET, path = "/error")
    public String triggerException(){
        throw new RuntimeException("error, not supposed to be here");
    }
}
