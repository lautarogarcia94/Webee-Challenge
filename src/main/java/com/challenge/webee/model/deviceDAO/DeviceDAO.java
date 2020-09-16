package com.challenge.webee.model.deviceDAO;

import com.challenge.webee.model.Device;
import com.challenge.webee.model.connection.ListConnection;
import com.challenge.webee.model.request.DeviceRequestModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DeviceDAO {

    /**
     * This method returns a list of devices.
     * @return List<Device>
     */
    public List<Device> getDevices() {
        /*List<Device> devList = new ArrayList<Device>();
        Device dev = new Device();
        dev.setDate(LocalDate.now());
        dev.setMacAdress("4F:24:AD:B1:90:21");
        dev.setID(23);

        devList.add(dev);
        Device dev1 = new Device();
        dev1.setDate(LocalDate.of(2020, 05, 24));
        dev1.setMacAdress("00:24:AD:00:90:00");
        dev1.setID(20);

        devList.add(dev1);

        return devList;*/
        return  ListConnection.getDeviceList();
    }

    /**
     * This method looks for a device with an id parameter. It return
     * a device if it exists a match, if not it returns a null.
     *
     * @param id Integer greater than 0
     * @return Device
     */
    public Device getDeviceById(int id) {

        /*
        Device dev = new Device();
        dev.setDate(LocalDate.of(2020, 02, 02));
        dev.setMacAdress("00:00:00:00:00:00");
        dev.setID(id);*/


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

    public void insertDevice(DeviceRequestModel dev){
        ListConnection.setDevice(dev);
    }

    public void deleteDevice(int id){
        ListConnection.deleteDevice(id);
    }

}
