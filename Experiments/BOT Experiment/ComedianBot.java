package com.example.myapplication;

import java.util.ArrayList;

public class ComedianBot extends JokeBot{


    public ComedianBot(String aName) {

        super(JokeWriter.getJokeListTwo());
        setName(aName);
    }

    public void performShow(){
        talk("Good evening everyone, my name is " + getName());
        talk("Why don't i tell you some of my favourate jokes");

        for (Joke oneJoke: jokesIKnow){
            deliverJoke(oneJoke);
        }

        talk("Thanks Everyone, GoodNight!");
    }

//    @Override
//    protected void sayJoke(Joke ajoke) {
//        talk(ajoke.getJokeSetup() + "," + ajoke.getJokePunchline());
//    }

    @Override
    protected void deliverJoke(Joke ajoke) {
        talk(ajoke.getJokeSetup() + "," + ajoke.getJokePunchline());
    }
}
