package de.thoughtsOnIt.unitTestTalk;

import de.thoughtsOnIt.unitTestTalk.PrimeNumberCheck;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglePrimeNumberCheckTest {

    @Test
    public void testPrimeNumberCheck(){
        PrimeNumberCheck cut = new PrimeNumberCheck();
        Short numberToTest = 42;

        boolean isPrime = cut.checkIfPrimeNumber(numberToTest);

        assertTrue(isPrime);
    }

    @Test
    public void testPrimeNumberCheck2(){
        PrimeNumberCheck cut = new PrimeNumberCheck();
        Short numberToTest = 3;

        boolean isPrime = cut.checkIfPrimeNumber(numberToTest);

        assertFalse(isPrime);
    }
}
