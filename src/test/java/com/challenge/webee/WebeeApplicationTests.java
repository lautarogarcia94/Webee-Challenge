package com.challenge.webee;

import com.challenge.webee.model.Device;
import com.challenge.webee.model.connection.ListConnection;
import com.challenge.webee.model.request.DeviceRequestModel;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class WebeeApplicationTests {


    @Test
    void listConection_2_setDevice() {
        DeviceRequestModel dev = new DeviceRequestModel();
        dev.setDate(LocalDate.of(2020, 05, 10));
        dev.setMacAddress("FF:FF:FF:FF:FF:FF");
        ListConnection.setDevice(dev);
        assertTrue(ListConnection.setDevice(dev).equalsIgnoreCase("Register OK"));
    }

    @Test
    void listConection_3_deleteDevice() {
        assertTrue(ListConnection.deleteDevice(1).equalsIgnoreCase("Device deleted OK"));
        assertTrue(ListConnection.deleteDevice(-1).equalsIgnoreCase("Device NOT deleted"));
        assertTrue(ListConnection.deleteDevice(10).equalsIgnoreCase("Device NOT deleted"));
    }

    @Test
    void listConection_1_getDeviceById() {
        DeviceRequestModel dev = new DeviceRequestModel();
        dev.setDate(LocalDate.of(2020, 01, 01));
        dev.setMacAddress("AA:AA:AA:AA:AA:AA");
        ListConnection.setDevice(dev);
        Device device = ListConnection.getDeviceById(1);
        assertEquals(device.getID(), 1);
        // assertTrue(device.getMacAddress().equalsIgnoreCase("AA:AA:AA:AA:AA:AA"));
        assertTrue(device.getDate().equals(LocalDate.of(2020, 01, 01)));
    }

    @Test
    void listConection_4_getDeviceByMac() {
        DeviceRequestModel dev = new DeviceRequestModel();
        dev.setDate(LocalDate.of(2020, 10, 22));
        dev.setMacAddress("00:00:00:00:00:00");
        ListConnection.setDevice(dev);
        Device device = ListConnection.getDeviceByMac("00:00:00:00:00:00");
        assertTrue(device.getMacAddress().equalsIgnoreCase("00:00:00:00:00:00"));
        assertTrue(device.getDate().equals(LocalDate.of(2020, 10, 22)));
    }


}
