package de.thoughtsOnIt.unitTestTalk.screenshots.stuff;

public class FoobarRepositoryFactory {

    private static FoobarRepository instance;

    public static FoobarRepository getInstance() {

        if(instance == null){
            instance = new JpaFoobarRepository();
        }

        return instance;
    }

    public static void setInstance(FoobarRepository repository){
        instance = repository;
    }
}
