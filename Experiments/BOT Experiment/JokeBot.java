package com.example.myapplication;

import java.util.ArrayList;

public abstract class JokeBot extends Bot {

    public static ArrayList<Joke> jokesIKnow = null;

    public JokeBot(ArrayList<Joke> jokesIKnow) {
        this.jokesIKnow = jokesIKnow;
    }

    public void tellJoke(){

        Double randomNumDouble = new Double(Math.random() * jokesIKnow.size());
        int randomNum = randomNumDouble.intValue();

        Joke myJoke = jokesIKnow.get(randomNum);

        sayJoke(myJoke);
    }

    protected void sayJoke(Joke ajoke){
        talk(ajoke.getJokeSetup());
        talk(ajoke.getJokePunchline());
    }

    protected abstract void deliverJoke(Joke ajoke);
}
