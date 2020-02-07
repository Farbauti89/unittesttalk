package de.thoughtsOnIt.unitTestTalk.screenshots.seams;

import de.thoughtsOnIt.unitTestTalk.screenshots.stuff.FoobarRepository;
import de.thoughtsOnIt.unitTestTalk.screenshots.stuff.Something;

public class FooBarServiceWithSetterInjection {

    private FoobarRepository repository;

    public void doSomething(){
        Something something = repository.findSomething();
        //do something with `something`
    }

    public void setRepository(FoobarRepository repository) {
        this.repository = repository;
    }
}
