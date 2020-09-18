package com.challenge.webee.model.deviceDAO;

import com.challenge.webee.model.Device;
import com.challenge.webee.model.connection.ListConnection;
import com.challenge.webee.model.request.DeviceRequestModel;

import java.util.List;

public class DeviceDAO {

    /**
     * Calls a ListConnection method to get a list of devices, and returns it.
     *
     * @return List<Device>
     */
    public List<Device> getDevices() {
        return ListConnection.getDeviceList();
    }

    /**
     * Calls a ListConnection method to look for a device with an id parameter, and
     * returns it.
     *
     * @param id Integer greater than 0
     * @return Device
     */
    public Device getDeviceById(int id) {
        return ListConnection.getDeviceById(id);
    }

    /**
     * Calls a ListConnection method to look for a device with an MAC addrress
     * parameter, and returns it.
     *
     * @param macAddress String must match
     * @return Device
     */
    public Device getDeviceByMAC(String macAddress) {
        return ListConnection.getDeviceByMac(macAddress);
    }


    /**
     * Calls a ListConnection method to register a device.
     *
     * @param dev
     */
    public void insertDevice(DeviceRequestModel dev) {
        ListConnection.setDevice(dev);
    }

    /**
     * Calls a ListConnection method to delete a device.
     *
     * @param id Integer greater than 0
     */
    public void deleteDevice(int id) {
        ListConnection.deleteDevice(id);
    }

}
