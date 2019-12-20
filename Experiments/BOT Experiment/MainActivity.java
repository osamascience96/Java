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

//        ArrayList<Joke> someJokes = JokeWriter.getJokeListOne();
//        JokeBot jokeBot = new JokeBot(someJokes);
//        jokeBot.tellJoke();

        ComedianBot docHilarious = new ComedianBot("Doctor Hilarious");
        docHilarious.performShow();

    }
}
