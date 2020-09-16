package com.challenge.webee.controller;

import com.challenge.webee.model.Device;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("devices")
public class DeviceController {

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Device getUsers() {
        Device dev = new Device();
        dev.setDate(LocalDate.now());
        dev.setMacAdress("4F:24:AD:B1:90:21");
        dev.setID("23");
        return dev;
    }
}
