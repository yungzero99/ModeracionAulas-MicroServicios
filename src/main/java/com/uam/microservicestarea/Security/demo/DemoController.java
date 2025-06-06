package com.uam.microservicestarea.Security.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @PostMapping("/welcome")
    public String welcome() {
        return "Demo Success";
    }
}
