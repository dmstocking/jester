package com.udacity.gradle.builditbigger.jokes;

public class Jokes {

    private final String[] jokes = new String[] {
            "Two bytes meet. The first byte asks, “Are you ill?”\n" +
                "The second byte replies, “No, just feeling a bit off.”",
            "Programming is like sex:\n" +
                "One mistake and you have to support it for the rest of your life.",
            "so this programmer goes out on a date with a hot chick",
            "There are no shortcuts in life, unless you right click and find one...",
            "Keyboard not found ... press F1 to continue",
            "A SQL query goes into a bar, walks up to two tables and asks, \"Can I join you?\"",
    };

    private final RandomUtils randomUtils;

    public Jokes(RandomUtils randomUtils) {
        this.randomUtils = randomUtils;
    }

    public String getJoke() {
        return jokes[randomUtils.random(0, jokes.length)];
    }
}
