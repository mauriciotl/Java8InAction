package lambdasinaction.chap2.mauPractice03_GenericsPredicate.domain;

import lambdasinaction.chap2.mauPractice03_GenericsPredicate.interfaces.PredicateGeneric;

import java.util.ArrayList;
import java.util.List;

public class FilterPredicateGeneric<T> {


    public static <T> List<T> filter(List<T> list, PredicateGeneric<T> p){

        List<T> result = new ArrayList<>();

        for(T t: list){
            if(p.test(t)){
                result.add(t);
            }
        }

        return result;
    }

}
