package com.challenge.webee.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class DeviceRequestModel {

    private static final String REGEXPMAC = "^([0-9A-Fa-f]{2}[:]){5}([0-9A-Fa-f]{2})$";


    //TODO: add date validator
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
    private LocalDate date;


    @Pattern(regexp = REGEXPMAC, message = "Not valid MAC adress")
    private String macAdress;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMacAdress() {
        return macAdress;
    }

    public void setMacAdress(String macAdress) {
        this.macAdress = macAdress;
    }
}
