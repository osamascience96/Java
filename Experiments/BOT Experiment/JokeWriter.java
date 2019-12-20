package com.example.myapplication;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by learnovate on 3/5/14.
 */
public class JokeWriter {

    public static ArrayList<Joke> getJokeListOne(){

        ArrayList<Joke> jokeList = new ArrayList<Joke>();

        jokeList.add(new Joke("Why couldn't the bicycle stand up?",
                              "Because it was two tired"));
        jokeList.add(new Joke("What do you call a cheese that isn't yours?",
                              "Nacho Cheese!"));
        jokeList.add(new Joke("Before I criticize a man, I like to walk a mile in his shoes.",
                              "That way, when I do criticize him, I'm a mile away and I have his shoes."));
        jokeList.add(new Joke("What do you call a fish with no eye?",
                              "Fssshh"));
        jokeList.add(new Joke("Have you heard the one about the Corduroy pillow?",
                              "It's making HEADLINES!"));
        jokeList.add(new Joke("What's red and bad for your teeth?",
                              "A brick."));
        return jokeList;
    }

    public static ArrayList<Joke> getJokeListTwo(){
        ArrayList<Joke> jokeList = new ArrayList<Joke>();

        jokeList.add(new Joke("Why didn't the melons get married?",
                              "Because they cantaloupe!"));
        jokeList.add(new Joke("What did the cobbler say when a cat wandered into his shop?",
                              "Shoe!"));
        jokeList.add(new Joke("The face of a child can say it all",
                              "especially the mouth part of the face."));
        jokeList.add(new Joke("Why did the cookie go to the hospital?",
                              "Because he felt crummy."));
        jokeList.add(new Joke("I intend to live forever...",
                              "So far, so good."));
        return jokeList;

    }

}
