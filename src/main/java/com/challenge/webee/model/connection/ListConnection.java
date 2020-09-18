package com.challenge.webee.model.connection;

import com.challenge.webee.model.Device;
import com.challenge.webee.model.request.DeviceRequestModel;

import java.util.ArrayList;
import java.util.List;

public class ListConnection {

    private static List<Device> deviceList = new ArrayList<>();
    private static int idCount = 0;

    /**
     * Register a Device, inserting it into a List<Device>.
     *
     * @param dev Device to be inserted
     */
    public static String setDevice(DeviceRequestModel dev) {
        Device device = new Device();
        device.setDate(dev.getDate());
        device.setMacAddress(dev.getMacAddress());
        device.setID(++idCount);
        deviceList.add(device);
        return "Register OK";
    }

    /**
     * Returns a List<Device> of all Devices registered.
     *
     * @return List<Device>
     */
    public static List<Device> getDeviceList() {
        return deviceList;
    }

    /**
     * Returns a single Device, looking it for ID. If there is any match,
     * it returns a Device initialized to null.
     *
     * @param id int greater than 0
     * @return Device
     */
    public static Device getDeviceById(int id) {
        Device device = new Device();
        for (Device dev : deviceList) {
            if (dev.getID() == id) {
                device = dev;
                break;
            }
        }
        return device;
    }

    /**
     * Returns a single Device, looking it for MAC address. If there is any match,
     * it returns a Device initialized to null.
     *
     * @param macAddress format FF:FF:FF:FF:FF:FF
     * @return Device
     */
    public static Device getDeviceByMac(String macAddress) {
        Device device = new Device();
        for (Device dev : deviceList) {
            if (dev.getMacAddress().equalsIgnoreCase(macAddress)) {
                device = dev;
                break;
            }
        }
        return device;
    }

    /**
     * Deletes a device, looking it for ID.
     *
     * @param id int greater than 0
     */
    public static String deleteDevice(int id) {
        int index = -1;
        for (Device dev : deviceList) {
            if (dev.getID() == id) {
                index = deviceList.indexOf(dev);
                break;
            }
        }

        if (index >= 0) {
            deviceList.remove(index);
            return "Device deleted OK";
        }
        return "Device NOT deleted";
    }
}
