package lambdasinaction.chap2.mauPractice.interfaces;

import lambdasinaction.chap2.mauPractice.domain.Apple;

public interface ApplePredicate {

    //The following method differ from a Strategy Pattern
    //interface, as this one is already tied to a specific object,
    //an Apple this time. Another difference is that The Strategy interface
    // is free to be used
    //as an Instance Variable in any object.
    //Also, the Strategy Pattern is more aimed to add flexible functionality
    //to a subtypes from a main/father class, it would be Apple in this case,
    //But from what I can see up to now the Predicate will provide different
    //functionality for a Specific Object and tight to it.
    boolean test(Apple apple);

}
