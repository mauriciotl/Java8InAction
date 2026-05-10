package lambdasinaction.chap2.mauPractice03_GenericsPredicate;

import lambdasinaction.chap2.mauPractice02.domain.Apple;
import lambdasinaction.chap2.mauPractice03_GenericsPredicate.domain.FilterPredicateGeneric;
import lambdasinaction.chap2.mauPractice03_GenericsPredicate.interfaces.PredicateGeneric;

import java.util.ArrayList;
import java.util.List;

public class AppUsingGenerics {




    public static void main(String[] args) {


        // The list db mocked:
        List<Apple> appleInventory = new ArrayList<>();
        appleInventory.add(new Apple(80, "green"));
        appleInventory.add(new Apple(155, "green"));
        appleInventory.add(new Apple(120, "red"));


        // The first application example:

        List<Apple> theAppleList = new ArrayList<>();

        theAppleList = FilterPredicateGeneric.filter(appleInventory, new PredicateGeneric<Apple>() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor().equals("red");
            }
        });

        System.out.println(theAppleList + "\n");

        // Same example using lambda exp:

        theAppleList = new ArrayList<>();

        theAppleList = FilterPredicateGeneric.filter(appleInventory,
                apple -> apple.getColor().equals("green"));

        System.out.println("Using lambda syntax: " + theAppleList + "\n");


        /*
         * Following example using a String
         */

        List<String> names = new ArrayList<>();
        names.add("Mauricio");
        names.add("Ariana");
        names.add("Emma Watson");
        names.add("Emma Stone");


        List<String> stringList = new ArrayList<>();

        stringList = FilterPredicateGeneric.filter(names, new PredicateGeneric<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("Emma");
            }
        });

        System.out.println(stringList);

        stringList = new ArrayList<>();
        stringList = FilterPredicateGeneric.filter(names, (name -> name.contains("Mau")));

        System.out.println("The names list using lambda anonymous function: " + stringList);

        /**
         * The following is a lambda implementation from chapter 3.
         */

        System.out.println("The following is a lambda implementation from chapter 3, using generics");
        System.out.println(FilterPredicateGeneric.filter(appleInventory, (Apple apple) -> apple.getWeight() > 100 ));


        //For practicing create a method that get a list that contains
       // x words in the list names

        List<String> newList =
                FilterPredicateGeneric
                        .filter(names,
                                (String s) -> s.contains("ma") || s.contains("Ma"));


        System.out.println("The newList is: " + newList);

    }//Ends main method


//    public static List<String> containsList (List<String> list, String s){
//
//
//        return FilterPredicateGeneric(list, string -> );
//    }



}
