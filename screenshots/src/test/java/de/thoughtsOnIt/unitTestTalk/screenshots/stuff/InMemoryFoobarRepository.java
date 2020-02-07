package de.thoughtsOnIt.unitTestTalk.screenshots.stuff;

import de.thoughtsOnIt.unitTestTalk.screenshots.stuff.FoobarRepository;
import de.thoughtsOnIt.unitTestTalk.screenshots.stuff.Something;

public class InMemoryFoobarRepository implements FoobarRepository {

    @Override
    public Something findSomething() {
        return new Something();
    }
}
