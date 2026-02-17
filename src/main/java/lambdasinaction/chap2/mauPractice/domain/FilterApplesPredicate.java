package lambdasinaction.chap2.mauPractice.domain;

import lambdasinaction.chap2.mauPractice.interfaces.ApplePredicate;

import java.util.ArrayList;
import java.util.List;

public class FilterApplesPredicate {

    // This class uses Apple, does not have Apple, pure functionality.

    //**********************************************************
    // The following is the Java 8 method related to Predicate:
    //**********************************************************

    /**
     * The following is the golden method, the one that will be using the predicate interface,
     * that allow us to pass different implementations.
     * Later when we call it, we will send the required implementation, or create one on the fly;
     * how cool is that?
     * This could be like the bridge class that holds the methods/functionalities.
     * The Strategy pattern does not have this bridge class, that's another difference from it too.
     */

    public List<Apple> filter(List<Apple> inventory, ApplePredicate p)
    {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;

    }//end method.


    //**********************************************************
    // I think we could use more methods that would use also the ApplePredicate
    //**********************************************************


}
