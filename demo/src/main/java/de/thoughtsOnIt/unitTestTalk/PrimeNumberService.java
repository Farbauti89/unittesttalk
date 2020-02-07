package de.thoughtsOnIt.unitTestTalk;

public class PrimeNumberService {

    private PrimeNumberCheck primeNumberCheck;
    private PrimeNumberRepository primeNumberRepository;

    public PrimeNumberService(PrimeNumberCheck primeNumberCheck, PrimeNumberRepository primeNumberRepository) {
        this.primeNumberCheck = primeNumberCheck;
        this.primeNumberRepository = primeNumberRepository;
    }

    public boolean add(Short primeNumber){
        if(primeNumberCheck.checkIfPrimeNumber(primeNumber)){
            primeNumberRepository.add(primeNumber);
            return true;
        }

        return false;
    }

}
