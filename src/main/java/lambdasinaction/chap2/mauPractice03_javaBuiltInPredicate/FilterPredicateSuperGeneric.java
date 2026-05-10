package lambdasinaction.chap2.mauPractice03_javaBuiltInPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterPredicateSuperGeneric
{

    public static <T> List<T> filter(List<T> list, Predicate<T> p){

        List<T> theList = new ArrayList<>();

        for (T t : list){

            if(p.test(t)){
                theList.add(t);
            }
        }

        return theList;
    }


}
