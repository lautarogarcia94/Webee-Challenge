package com.challenge.webee.controller;

import com.challenge.webee.model.Device;
import com.challenge.webee.model.deviceDAO.DeviceDAO;
import com.challenge.webee.model.request.DeviceRequestModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("devices")
public class DeviceController {

    private static final String REGEXPMAC = "^([0-9A-Fa-f]{2}[:]){5}([0-9A-Fa-f]{2})$";

    /**
     * This method returns a JSON or XML formatted List of saved
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
     * Returns a device depending on devInfo parameter (id or MAC address), when receiving
     * a GET request in the endpoint .../devices/{devInfo}
     *
     * @param devInfo ID or MAC address of a device
     * @return Device if it exist (if not it returns a null Device), as a body of a HTTP
     * OK message
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
                return new ResponseEntity<>(devDao.getDeviceById(id), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
            }
        }
    }

    /**
     * Register a new Device using date and MAC address, when receiving a POST request
     * in the endpoint .../devices. The parameters have to been send in the body of the HTTP request.
     * These method would expect a body message like these:
     * {
     * "date": "21042020",
     * "macAddress": "FF:AA:FF:24:24:FF"
     * }
     *
     * @param dev Device parameter (date and MAC address only) which is tested before doing anything
     * @return HTTP Created message - 201
     */
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Device> createUser(@Valid @RequestBody DeviceRequestModel dev) {

        if (dev.getDate().compareTo(LocalDate.of(2020, 01, 01)) < 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        DeviceDAO devDao = new DeviceDAO();
        devDao.insertDevice(dev);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    /**
     * Delete a Device using a device ID parameter, when receiving  a DELETE request in
     * the endpoint .../devices/{devInfo}
     *
     * @param devInfo ID of a device
     * @return HTTP OK message - 200
     */
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
