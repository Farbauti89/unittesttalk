package de.thoughtsOnIt.unitTestTalk.screenshots.seams;

import de.thoughtsOnIt.unitTestTalk.screenshots.stuff.FoobarRepository;
import de.thoughtsOnIt.unitTestTalk.screenshots.stuff.Something;

public class FooBarServiceWithConstructorInjection {

    private FoobarRepository repository;

    public FooBarServiceWithConstructorInjection(FoobarRepository repository) {
        this.repository = repository;
    }

    public void doSomething(){
        Something something = repository.findSomething();
        //do something with `something`
    }
}
