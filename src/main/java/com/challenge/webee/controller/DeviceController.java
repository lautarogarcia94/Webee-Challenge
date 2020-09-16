package com.challenge.webee.controller;

import com.challenge.webee.model.Device;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("devices")
public class DeviceController {

    /**
     * This method returns a JSON or XML formated List of saved
     * devices, when receiving a GET request in the endpoint .../devices
     *
     * @return List<Device>
     */
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Device> getUsers() {
        List<Device> devList = new ArrayList<Device>();
        Device dev = new Device();
        dev.setDate(LocalDate.now());
        dev.setMacAdress("4F:24:AD:B1:90:21");
        dev.setID("23");

        devList.add(dev);

        dev.setDate(LocalDate.of(2020, 05, 24));
        dev.setMacAdress("00:24:AD:00:90:00");
        dev.setID("20");

        devList.add(dev);

        return devList;
    }

    
}
