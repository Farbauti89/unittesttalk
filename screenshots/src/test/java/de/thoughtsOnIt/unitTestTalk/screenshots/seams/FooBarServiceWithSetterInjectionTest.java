package de.thoughtsOnIt.unitTestTalk.screenshots.seams;

import de.thoughtsOnIt.unitTestTalk.screenshots.seams.FooBarServiceWithSetterInjection;
import de.thoughtsOnIt.unitTestTalk.screenshots.stuff.InMemoryFoobarRepository;
import org.junit.jupiter.api.Test;

class FooBarServiceWithSetterInjectionTest {

    @Test
    public void testFoobarService() {
        InMemoryFoobarRepository inMemoryFoobarRepository = new InMemoryFoobarRepository();
        FooBarServiceWithSetterInjection cut = new FooBarServiceWithSetterInjection();
        cut.setRepository(inMemoryFoobarRepository);

        cut.doSomething();

        //assert something
    }
}
