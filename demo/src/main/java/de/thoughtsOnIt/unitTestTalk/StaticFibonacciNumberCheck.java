package de.thoughtsOnIt.unitTestTalk;

import java.util.stream.Stream;

public class StaticFibonacciNumberCheck {

    private static Short[] fibonacciNumbers = {0,
                                               1,
                                               2,
                                               3,
                                               5,
                                               8,
                                               13,
                                               21,
                                               34,
                                               55,
                                               89,
                                               144,
                                               233,
                                               377,
                                               610,
                                               987,
                                               1597,
                                               2584,
                                               4181,
                                               6765,
                                               10946,
                                               17711,
                                               28657};

    public boolean checkIfFibonacciNumber(Short number) {

        if (number < 0) {
            throw new IllegalArgumentException("Number must be greater than zero.");
        }

        return Stream.of(fibonacciNumbers).anyMatch(aShort -> aShort.equals(number));
    }

}
