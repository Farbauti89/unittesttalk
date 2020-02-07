package de.thoughtsOnIt.unitTestTalk.screenshots.seams;

import de.thoughtsOnIt.unitTestTalk.screenshots.stuff.FoobarRepository;
import de.thoughtsOnIt.unitTestTalk.screenshots.stuff.FoobarRepositoryFactory;
import de.thoughtsOnIt.unitTestTalk.screenshots.stuff.Something;

public class FooBarServiceWithFactoryInjection {

    public void doSomething() {
        FoobarRepository repository = FoobarRepositoryFactory.getInstance();
        Something something = repository.findSomething();
        //do something with `something`
    }
}
