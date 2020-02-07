package de.thoughtsOnIt.unitTestTalk;

public class PrimeNumberCheck {

    public boolean checkIfPrimeNumber(Short number) {

        if(number < 0){
            throw new IllegalArgumentException("Number must be greater than zero.");
        }

        for (int i = 2; i <= number / 2; ++i) {
            if (number % i == 0) {
                return true;
            }
        }

        return false;
    }

    public boolean checkIfNotPrimeNumber(Short number){
        return !checkIfPrimeNumber(number);
    }

}
