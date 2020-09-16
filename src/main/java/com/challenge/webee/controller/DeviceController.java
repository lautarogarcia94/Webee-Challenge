package com.challenge.webee.controller;

import com.challenge.webee.model.Device;
import com.challenge.webee.model.deviceDAO.DeviceDAO;
import com.challenge.webee.model.request.DeviceRequestModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        DeviceDAO devDao = new DeviceDAO();

        return devDao.getDevices();
    }

    /**
     * @param devInfo
     * @return
     */
    @GetMapping(path = "/{devInfo}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Device> getDevice(@PathVariable String devInfo) {
        int id;
        DeviceDAO devDao = new DeviceDAO();

        if (devInfo.matches(REGEXPMAC)) {
            return new ResponseEntity<>(devDao.getDeviceByMAC(devInfo), HttpStatus.OK);
        } else {
            try {
                id = Integer.parseInt(devInfo);
                return new ResponseEntity<>(devDao.getDeviceById(id), HttpStatus.ACCEPTED);

            } catch (Exception e) {

            }
        }
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Device> createUser(@Valid @RequestBody DeviceRequestModel dev) {
/*
        Device device = new Device();
        device.setMacAdress(dev.getMacAdress());
        device.setDate(dev.getDate());*/

        DeviceDAO devDao = new DeviceDAO();
        devDao.insertDevice(dev);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{devInfo}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<String> deleteDevice(@PathVariable String devInfo) {

        int id;
        try {
            id = Integer.parseInt(devInfo);
        } catch (Exception e) {
            return new ResponseEntity<>("Not valid ID", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if (id < 0) {
            return new ResponseEntity<>("Not valid ID", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        DeviceDAO devDao = new DeviceDAO();
        devDao.deleteDevice(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
