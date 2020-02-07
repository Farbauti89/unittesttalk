package de.thoughtsOnIt.unitTestTalk.screenshots.seams;

import de.thoughtsOnIt.unitTestTalk.screenshots.stuff.FoobarRepository;
import de.thoughtsOnIt.unitTestTalk.screenshots.stuff.JpaFoobarRepository;
import de.thoughtsOnIt.unitTestTalk.screenshots.stuff.Something;

public class FooBarServiceWithExtractAndOverride {

    public void doSomething(){
        FoobarRepository repository = getFooBarRepository();
        Something something = repository.findSomething();
        //do something with `something`
    }

    protected FoobarRepository getFooBarRepository() {
        return new JpaFoobarRepository();
    }
}
