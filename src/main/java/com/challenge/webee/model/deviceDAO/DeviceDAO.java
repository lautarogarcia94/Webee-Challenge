package com.challenge.webee.model.deviceDAO;

import com.challenge.webee.model.Device;
import com.challenge.webee.model.connection.ListConnection;
import com.challenge.webee.model.request.DeviceRequestModel;

import java.time.LocalDate;
import java.util.List;

public class DeviceDAO {

    /**
     * This method returns a list of devices.
     *
     * @return List<Device>
     */
    public List<Device> getDevices() {
        return ListConnection.getDeviceList();
    }

    /**
     * This method looks for a device with an id parameter. It return
     * a device if it exists a match, if not it returns a null.
     *
     * @param id Integer greater than 0
     * @return Device
     */
    public Device getDeviceById(int id) {
        return ListConnection.getDeviceById(id);
    }

    /**
     * This method looks for a device with an MAC adrress parameter.
     * It return a device if it exists a match, if not it returns a null.
     *
     * @param macAdress String must match
     * @return Device
     */
    public Device getDeviceByMAC(String macAdress) {
        Device dev = new Device();
        dev.setDate(LocalDate.of(2020, 02, 02));
        dev.setMacAdress(macAdress);
        dev.setID(45);
        return ListConnection.getDeviceByMac(macAdress);
    }

    public void insertDevice(DeviceRequestModel dev) {
        ListConnection.setDevice(dev);
    }

    public void deleteDevice(int id) {
        ListConnection.deleteDevice(id);
    }

}
