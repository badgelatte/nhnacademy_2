package com.nhnacademy.exam020105;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.util.Random;

import org.junit.jupiter.api.RepeatedTest;

/**
 * class Ball unit test.
 */
class TestBall {
    Random random = new Random();

    @RepeatedTest(100)
    void testConstructor() {
        int radius = 1 + random.nextInt(Integer.MAX_VALUE);
        int x = random.nextInt(Integer.MAX_VALUE - radius) * (random.nextBoolean() ? 1 : -1);
        int y = random.nextInt(Integer.MAX_VALUE - radius) * (random.nextBoolean() ? 1 : -1);

        assertDoesNotThrow(() -> {
            new Ball(x, y, radius);
        });
    }

    @RepeatedTest(100)
    void testConstructorWithInvalidSizeException() {
        int x = random.nextInt();
        int y = random.nextInt();
        int radius = random.nextInt(Integer.MAX_VALUE) * -1;

        assertThrowsExactly(InvalidSizeException.class, () -> {
            new Ball(x, y, radius);
        });
    }

    @RepeatedTest(100)
    void testConstructorWithOutOfRangeException() {
        int x = random.nextInt();
        int y = random.nextInt();
        int radius = Integer.MAX_VALUE - random.nextInt(Math.max(Math.abs(x), Math.abs(y))) + 1;

        assertThrowsExactly(OutOfRangeException.class, () -> {
            new Ball(x, y, radius);
        });
    }

}
