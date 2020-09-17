package com.challenge.webee.model.connection;

import com.challenge.webee.model.Device;
import com.challenge.webee.model.request.DeviceRequestModel;

import java.util.ArrayList;
import java.util.List;

public class ListConnection {

    private static List<Device> deviceList = new ArrayList<>();
    private static int idCount = 0;

    public static void setDevice(DeviceRequestModel dev) {
        Device device = new Device();
        device.setDate(dev.getDate());
        device.setMacAdress(dev.getMacAdress());
        device.setID(++idCount);
        deviceList.add(device);
    }

    public static List<Device> getDeviceList() {
        return deviceList;
    }

    public static Device getDeviceById(int id) {

        Device device = new Device();
        for (Device dev: deviceList) {
            if(dev.getID() == id) {
                device = dev;
                break;
            }
        }
        return device;
    }

    public static Device getDeviceByMac(String macAdress) {

        Device device = new Device();
        for (Device dev: deviceList) {
            if(dev.getMacAdress().equalsIgnoreCase(macAdress)) {
                device = dev;
                break;
            }
        }
        return device;
    }

    public static void deleteDevice(int id){
        int index = -1;
        for (Device dev: deviceList) {
            if(dev.getID() == id) {
                index = deviceList.indexOf(dev);
                break;
            }
        }

        if(index>=0){
            deviceList.remove(index);
        }
    }
}
