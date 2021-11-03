package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fan myFan = new Fan();
        Light myLight = new Light();

        myFan.breakDevice();
        myLight.breakDevice();

        Switch mySwitch = new Switch();
        mySwitch.wireUp(myFan);
        mySwitch.wireUp(myLight);

        mySwitch.flipSwitchUp();
        mySwitch.flipSwitchDown();

        mySwitch.unWire(myFan);

        mySwitch.flipSwitchUp();
        mySwitch.flipSwitchDown();


    }
}
