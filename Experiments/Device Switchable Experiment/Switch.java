package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class Switch {

    private List<Switchable> switchableList = new ArrayList<Switchable>();


    public void wireUp(Switchable thing){
        switchableList.add(thing);
    }

    // unwire the devices in case of memory leak
    public void unWire(Switchable thing){
        switchableList.remove(thing);
    }

    public void flipSwitchUp(){
        for (Switchable thing: switchableList){
            thing.turnOn();
        }
    }

    public void flipSwitchDown(){
        for (Switchable thing: switchableList){
            thing.turnOff();
        }
    }
}
