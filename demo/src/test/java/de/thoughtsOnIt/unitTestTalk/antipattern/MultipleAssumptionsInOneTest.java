package de.thoughtsOnIt.unitTestTalk.antipattern;

import java.util.stream.Stream;

import de.thoughtsOnIt.unitTestTalk.StaticFibonacciNumberCheck;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * Anti-Pattern: multiple Assumptions in one test
 *
 * Problems:
 *  * violates Separation of Concerns
 *  ** this leads to an unprecise testname
 *  ** increased  cognitive load for developer reading this class
 *  ** decreased readability
 *  ** decreased maintainability
 *
 *  Solution:
 *  * split into multiple, well named tests
 *
 */
public class MultipleAssumptionsInOneTest {

    @ParameterizedTest
    @MethodSource("createNumbersWithFibonacciIndicator")
    public void testFibonacciNumberCheck(Short numberToTest, boolean isFibonacciExpected) {
        StaticFibonacciNumberCheck cut = new StaticFibonacciNumberCheck();

        if(numberToTest >= 0) {
            boolean isFibonacci = cut.checkIfFibonacciNumber(numberToTest);
            assertEquals(isFibonacciExpected, isFibonacci);
        } else {
            assertThrows(IllegalArgumentException.class, () -> cut.checkIfFibonacciNumber(numberToTest));
        }

    }

    private static Stream<Arguments> createNumbersWithFibonacciIndicator() {
        return Stream.of(
                Arguments.of(Short.valueOf((short) 0), true),
                Arguments.of(Short.valueOf((short) 1), true),
                Arguments.of(Short.valueOf((short) 2), true),
                Arguments.of(Short.valueOf((short) 3), true),
                Arguments.of(Short.valueOf((short) 4), false),
                Arguments.of(Short.MAX_VALUE, false),
                Arguments.of(Short.MIN_VALUE, false));
    }

}
