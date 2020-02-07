package de.thoughtsOnIt.unitTestTalk.antipattern;

import de.thoughtsOnIt.unitTestTalk.PrimeNumberCheck;
import de.thoughtsOnIt.unitTestTalk.StaticFibonacciNumberCheck;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * Anti-Pattern: Test multiple Units in one testclass
 *
 * Problems:
 *  * violates Separation of Concerns
 *  ** this leads to the strange classname
 *  ** increased  cognitive load for developer reading this class
 *  ** decreased readability
 *  ** decreased maintainability
 *
 *  Solution:
 *  * split into multiple testclasses
 *
 */
public class MultipleTestedClassesPerTest {

    @Test
    public void testPrimeNumberCheck(){
        PrimeNumberCheck cut = new PrimeNumberCheck();
        Short numberToTest = 42;

        boolean isPrime = cut.checkIfPrimeNumber(numberToTest);

        assertTrue(isPrime);
    }

    @Test
    public void testFibonacciNumberCheck(){
        StaticFibonacciNumberCheck cut = new StaticFibonacciNumberCheck();
        Short numberToTest = 42;

        boolean isPrime = cut.checkIfFibonacciNumber(numberToTest);

        assertFalse(isPrime);
    }

}
