package com.example.myapplication;

public abstract class Device {
    private String deviceName;
    private boolean isOn;

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public abstract void breakDevice();

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public void getDeviceStatus(){
        System.out.println(getDeviceName()+" "+isOn());
    }
}
