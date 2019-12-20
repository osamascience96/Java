package com.example.myapplication;

/**
 * Created by learnovate on 3/5/14.
 * Set the joke and punchline for the bot
 */
public class Joke {

    private String jokeSetup;
    private String jokePunchline;

    public Joke(String jokeSetup, String jokePunchline){
        this.jokeSetup = jokeSetup;
        this.jokePunchline = jokePunchline;
    }

    public void setJokeSetup(String jokeSetup){
        this.jokeSetup = jokeSetup;
    }

    public String getJokeSetup(){
        return jokeSetup;
    }

    public void setJokePunchline(String jokePunchline){
        this.jokePunchline = jokePunchline;
    }

    public String getJokePunchline(){
        return jokePunchline;
    }
}
