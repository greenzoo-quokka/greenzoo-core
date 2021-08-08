package com.greenzoo.jpa.greenzoojpa.jpa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public Object index() {
        return "test";
    }

}
