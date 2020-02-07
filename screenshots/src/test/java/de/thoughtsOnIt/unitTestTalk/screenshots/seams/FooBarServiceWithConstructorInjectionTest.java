package de.thoughtsOnIt.unitTestTalk.screenshots.seams;

import de.thoughtsOnIt.unitTestTalk.screenshots.seams.FooBarServiceWithConstructorInjection;
import de.thoughtsOnIt.unitTestTalk.screenshots.stuff.InMemoryFoobarRepository;
import org.junit.jupiter.api.Test;

class FooBarServiceWithConstructorInjectionTest {

    @Test
    public void testFoobarService() {
        InMemoryFoobarRepository inMemoryFoobarRepository = new InMemoryFoobarRepository();
        FooBarServiceWithConstructorInjection cut = new FooBarServiceWithConstructorInjection(inMemoryFoobarRepository);

        cut.doSomething();

        //assert something
    }
}
