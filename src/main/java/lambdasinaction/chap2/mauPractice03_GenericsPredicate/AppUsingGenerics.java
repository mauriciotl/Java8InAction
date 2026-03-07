package lambdasinaction.chap2.mauPractice03_GenericsPredicate;

import lambdasinaction.chap2.mauPractice02.domain.Apple;
import lambdasinaction.chap2.mauPractice03_GenericsPredicate.domain.FilterPredicateGeneric;
import lambdasinaction.chap2.mauPractice03_GenericsPredicate.interfaces.PredicateGeneric;

import java.util.ArrayList;
import java.util.List;

public class AppUsingGenerics {




    public static void main(String[] args) {


        List<Apple> appleInventory = new ArrayList<>();
        appleInventory.add(new Apple(80, "green"));
        appleInventory.add(new Apple(155, "green"));
        appleInventory.add(new Apple(120, "red"));

        FilterPredicateGeneric<Apple> filterGeneric = new FilterPredicateGeneric<>();

        List<Apple> newAppleList = new ArrayList<>();


        newAppleList = filterGeneric.filter(appleInventory, new PredicateGeneric<Apple>() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor().equals("red");
            }
        });

        System.out.println(newAppleList + "\n");



        /*
         * Following example using a String
         */

        List<String> names = new ArrayList<>();
        names.add("Mauricio");
        names.add("Ariana");
        names.add("Emma Watson");
        names.add("Emma Stone");


        List<String> stringList = new ArrayList<>();

        FilterPredicateGeneric<String> filterGenericString = new FilterPredicateGeneric<>();

        stringList = filterGenericString.filter(names, new PredicateGeneric<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("Emma");
            }
        });

        System.out.println(stringList);

    }//Ends main method


}
