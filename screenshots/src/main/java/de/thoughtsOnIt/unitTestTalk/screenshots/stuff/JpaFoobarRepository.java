package de.thoughtsOnIt.unitTestTalk.screenshots.stuff;

public class JpaFoobarRepository implements FoobarRepository {

    @Override
    public Something findSomething() {
        //use JPA to retrieve some data
        return new Something();
    }
}
