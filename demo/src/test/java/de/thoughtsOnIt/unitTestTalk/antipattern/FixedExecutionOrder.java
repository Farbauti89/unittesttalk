package de.thoughtsOnIt.unitTestTalk.antipattern;

import de.thoughtsOnIt.unitTestTalk.PrimeNumberCheck;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Anti-Pattern: Dependent Tests
 * <p>
 * Description: {@link #testIfNotPrimeNumberCheck()} depends on the execution of {@link #testPrimeNumberCheck()}
 * Because there is no guarantee in the order of the test execution this test is flaky.
 * <p>
 * Problems:
 * * Tests depend on each other
 * * {@link #testIfNotPrimeNumberCheck()} has two reasons to fail
 * ** the tested behaviour in {@link #testPrimeNumberCheck()} has a bug
 * ** the tested behaviour of {@link #testIfNotPrimeNumberCheck()} has a bug
 * <p>
 * Solution:
 * * split into multiple, well named tests
 */
public class FixedExecutionOrder {

    private static Boolean isPrime;

    @Test
    public void testPrimeNumberCheck() {
        PrimeNumberCheck cut = new PrimeNumberCheck();
        Short numberToTest = 42;

        isPrime = cut.checkIfPrimeNumber(numberToTest);

        assertTrue(isPrime);
    }

    @Test
    public void testIfNotPrimeNumberCheck() {
        PrimeNumberCheck cut = new PrimeNumberCheck();
        Short numberToTest = 42;

        boolean isNotPrime = cut.checkIfNotPrimeNumber(numberToTest);

        assertEquals(!isPrime, isNotPrime);
    }
}
