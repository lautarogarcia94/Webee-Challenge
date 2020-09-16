package com.challenge.webee.controller;

import com.challenge.webee.model.Device;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("devices")
public class DeviceController {

    private static final String REGEXPMAC = "^([0-9A-Fa-f]{2}[:]){5}([0-9A-Fa-f]{2})$";

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

    /**
     * @param devInfo
     * @return
     */
    @GetMapping(path = "/{devInfo}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Device> getDevice(@PathVariable String devInfo) {
        int id;
        Device dev = new Device();
        dev.setDate(LocalDate.now());
        dev.setMacAdress("4F:24:AD:B1:90:21");
        dev.setID("23");
        if (devInfo.matches(REGEXPMAC)) {
            dev.setMacAdress(devInfo);
            return new ResponseEntity<Device>(dev, HttpStatus.ACCEPTED);
        } else {
            try {
                id = Integer.parseInt(devInfo);
                dev.setID(devInfo);
                return new ResponseEntity<Device>(dev, HttpStatus.ACCEPTED);

            } catch (Exception e) {

            }
        }
        return new ResponseEntity<Device>(HttpStatus.NOT_ACCEPTABLE);
    }

    
}
