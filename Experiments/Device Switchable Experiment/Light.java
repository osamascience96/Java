package com.example.myapplication;

public class Light extends Device implements Switchable{

    public Light(){
        setDeviceName("Light");
    }

    @Override
    public void breakDevice(){
        System.out.println(getDeviceName()+ " " + "Tissshhhhhhh..... broken into pieces.");
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
}
