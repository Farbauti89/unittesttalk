package de.thoughtsOnIt.unitTestTalk.screenshots.seams;

import de.thoughtsOnIt.unitTestTalk.screenshots.seams.FooBarServiceWithExtractAndOverride;
import de.thoughtsOnIt.unitTestTalk.screenshots.stuff.FoobarRepository;
import de.thoughtsOnIt.unitTestTalk.screenshots.stuff.InMemoryFoobarRepository;
import org.junit.jupiter.api.Test;

class FooBarServiceWithExtractAndOverrideTest {

    @Test
    public void testFoobarService() {
        FooBarServiceWithExtractAndOverride cut = new FooBarServiceWithExtractAndOverride(){
            @Override
            protected FoobarRepository getFooBarRepository() {
                return new InMemoryFoobarRepository();
            }
        };

        cut.doSomething();

        //assert something
    }
}
