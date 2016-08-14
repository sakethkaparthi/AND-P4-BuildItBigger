package com.example;

import java.util.Random;

public class Javajoker {
    public String getAJoke() {
        String jokes[] = {"This is supposed to be a joke. Please laugh!", "This is not a joke but you can laugh if you want to.", "Hi. I am Rick Harrison and this is my pawn shop"
                , "You never know whats gonna come through that door", "You want 2000$ for this? The best i can do is 10$", "I am not sure what we are talking about. Let me call a buddy of mine"};
        Random random = new Random();
        int r = random.nextInt(jokes.length);
        return jokes[r];
    }
}
