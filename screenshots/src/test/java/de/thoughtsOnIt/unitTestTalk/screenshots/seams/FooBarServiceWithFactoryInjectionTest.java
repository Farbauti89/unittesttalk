package de.thoughtsOnIt.unitTestTalk.screenshots.seams;

import de.thoughtsOnIt.unitTestTalk.screenshots.seams.FooBarServiceWithFactoryInjection;
import de.thoughtsOnIt.unitTestTalk.screenshots.stuff.FoobarRepositoryFactory;
import de.thoughtsOnIt.unitTestTalk.screenshots.stuff.InMemoryFoobarRepository;
import org.junit.jupiter.api.Test;

class FooBarServiceWithFactoryInjectionTest {

    @Test
    public void testFoobarService() {
        FoobarRepositoryFactory.setInstance(new InMemoryFoobarRepository());
        FooBarServiceWithFactoryInjection cut = new FooBarServiceWithFactoryInjection();

        cut.doSomething();

        //assert something
    }
}
