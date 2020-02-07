package de.thoughtsOnIt.unitTestTalk;

import java.util.stream.Stream;

import de.thoughtsOnIt.unitTestTalk.PrimeNumberCheck;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParameterizedPrimeNumberCheckTest {

    @ParameterizedTest
    @MethodSource("createNumbersWithPrimeIndicator")
    public void testPrimeNumberCheck(Short numberToTest, boolean isPrimeExpected) {
        PrimeNumberCheck cut = new PrimeNumberCheck();

        boolean isPrimeActual = cut.checkIfPrimeNumber(numberToTest);

        assertEquals(isPrimeExpected, isPrimeActual);
    }

    @Test
    public void when_PassingANumberLowerThanZero_AIllegalArgumentExceptionShouldBeThrown(){
        PrimeNumberCheck cut = new PrimeNumberCheck();

        assertThrows(IllegalArgumentException.class, () -> cut.checkIfPrimeNumber(Short.MIN_VALUE));
    }

    private static Stream<Arguments> createNumbersWithPrimeIndicator() {
        return Stream.of(
                Arguments.of(Short.valueOf((short) 0), false),
                Arguments.of(Short.valueOf((short) 1), false),
                Arguments.of(Short.valueOf((short) 2), false),
                Arguments.of(Short.valueOf((short) 3), false),
                Arguments.of(Short.valueOf((short) 4), true),
                Arguments.of(Short.MAX_VALUE, true));
    }
}
