package com.example;

import java.util.Random;

public class Javajoker {
    public String getAJoke() {
        String jokes[] = {"This is supposed to be a joke. Please laugh!", "This is not a joke but you can laugh if you want to.", "Can a kangaroo jump higher than a house? Of course, a house doesn’t jump at all."
                , " Anton, do you think I’m a bad mother?\n" +
                "\n" +
                "My name is Paul.", "*insert joke here*", "Do robots say Hello world as their first word?"};
        Random random = new Random();
        int r = random.nextInt(jokes.length);
        return jokes[r];
    }
}
