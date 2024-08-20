package com.nhnacademy.exam020104;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.Test;

/**
 * class Ball unit test.
 */
class TestBall {
    @Test
    void testConstructor() {
        assertDoesNotThrow(() -> {
            new Ball(0, 0, 1);
            new Ball(0, 0, Integer.MAX_VALUE);
            new Ball(100, 100, 100);
            new Ball(100, -100, 100);
            new Ball(-100, 100, 100);
            new Ball(-100, -100, 100);
            new Ball(Integer.MIN_VALUE + 1, Integer.MIN_VALUE + 1, 1);
            new Ball(Integer.MIN_VALUE + 1, Integer.MAX_VALUE - 1, 1);
            new Ball(Integer.MAX_VALUE - 1, Integer.MIN_VALUE + 1, 1);
            new Ball(Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 1, 1);
        });
    }

    @Test
    void testConstructorWithInvalidSizeException() {
        assertThrowsExactly(InvalidSizeException.class, () -> {
            new Ball(0, 0, 0);
        });

        assertThrowsExactly(InvalidSizeException.class, () -> {
            new Ball(0, 0, -1);
        });

        assertThrowsExactly(InvalidSizeException.class, () -> {
            new Ball(0, 0, Integer.MIN_VALUE);
        });
    }

    @Test
    void testConstructorWithOutOfRangeException() {
        assertThrowsExactly(OutOfRangeException.class, () -> {
            new Ball(Integer.MAX_VALUE, 0, 1);
        });

        assertThrowsExactly(OutOfRangeException.class, () -> {
            new Ball(0, Integer.MAX_VALUE, 1);
        });

        assertThrowsExactly(OutOfRangeException.class, () -> {
            new Ball(Integer.MIN_VALUE, 0, 1);
        });

        assertThrowsExactly(OutOfRangeException.class, () -> {
            new Ball(0, Integer.MIN_VALUE, 1);
        });

        assertThrowsExactly(OutOfRangeException.class, () -> {
            new Ball(Integer.MIN_VALUE, Integer.MIN_VALUE, 1);
        });

        assertThrowsExactly(OutOfRangeException.class, () -> {
            new Ball(Integer.MAX_VALUE, Integer.MIN_VALUE, 1);
        });

        assertThrowsExactly(OutOfRangeException.class, () -> {
            new Ball(Integer.MIN_VALUE, Integer.MAX_VALUE, 1);
        });

        assertThrowsExactly(OutOfRangeException.class, () -> {
            new Ball(Integer.MAX_VALUE, Integer.MAX_VALUE, 1);
        });

        assertThrowsExactly(OutOfRangeException.class, () -> {
            new Ball(Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
        });

        assertThrowsExactly(OutOfRangeException.class, () -> {
            new Ball(0, Integer.MAX_VALUE, Integer.MAX_VALUE);
        });

        assertThrowsExactly(OutOfRangeException.class, () -> {
            new Ball(Integer.MIN_VALUE, 0, Integer.MAX_VALUE);
        });

        assertThrowsExactly(OutOfRangeException.class, () -> {
            new Ball(0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        });
    }
}
