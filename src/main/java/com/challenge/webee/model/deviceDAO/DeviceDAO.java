package com.challenge.webee.model.deviceDAO;

import com.challenge.webee.model.Device;
import com.challenge.webee.model.request.DeviceRequestModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DeviceDAO {

    public List<Device> getDevices() {
        List<Device> devList = new ArrayList<Device>();
        Device dev = new Device();
        dev.setDate(LocalDate.now());
        dev.setMacAdress("4F:24:AD:B1:90:21");
        dev.setID("23");

        devList.add(dev);
        Device dev1 = new Device();
        dev1.setDate(LocalDate.of(2020, 05, 24));
        dev1.setMacAdress("00:24:AD:00:90:00");
        dev1.setID("20");

        devList.add(dev1);

        return devList;
    }

  /*  public Device getDeviceById(int id);

    public Device getDeviceByMAC(String macAdress);

    public void insertDevice(DeviceRequestModel dev);

    public void deleteDevice(int id);
*/
}
