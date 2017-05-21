package com.udacity.gradle.builditbigger.jokes;

import java.util.Random;

public class RandomUtils {

    private final Random random = new Random();

    public int random(int inclusiveStart, int exclusiveEnd) {
        return random.nextInt(exclusiveEnd - inclusiveStart) + inclusiveStart;
    }
}
