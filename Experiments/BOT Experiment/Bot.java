package com.example.myapplication;

//Generic Bot
// bot can setname and speak

public class Bot {

    private final static String creatorName = "Osama"; // creatorName

    private String name = "ROBOT"; // RobotName default value

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected void talk(String whatToSay){
        System.out.println(getName() +" "+ whatToSay);
    }
}
