package com.example.myapplication;

public class Fan extends Device implements Switchable{


    public Fan(){
        setDeviceName("Fan");
    }

    @Override
    public void turnOn() {
        setOn(true);
        System.out.println(getDeviceName()+" The Device Status is "+isOn());
    }

    @Override
    public void turnOff() {
        setOn(false);
        System.out.println(getDeviceName()+" The Device Status is "+isOn());
    }


    @Override
    public void breakDevice() {
        System.out.println(getDeviceName()+ " " + "Daangggggg...... smashed on to the floor");
    }


}
