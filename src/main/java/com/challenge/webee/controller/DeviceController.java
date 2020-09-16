package com.challenge.webee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("devices")
public class DeviceController {

    @GetMapping()
    public String getUsers() {
        return "Hello world";
    }
}
