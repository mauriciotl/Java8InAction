package lambdasinaction.chap3.mauPractice_ComparatorAndSort;

import lambdasinaction.chap3.mauPractice_ComparatorAndSort.domain.Apple;
import lambdasinaction.chap3.mauPractice_ComparatorAndSort.domain.MySortGeneric;
import lambdasinaction.chap3.mauPractice_ComparatorAndSort.interfaces.MyComparatorGeneric;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AppSortJava8LambdasWay {


    public static void main(String[] args){



        List<Apple> appleInventory = new ArrayList<>();
        appleInventory.add(new Apple(80, "green"));
        appleInventory.add(new Apple(155, "green"));
        appleInventory.add(new Apple(120, "red"));


        //Need to sort that previous list

        MySortGeneric<Apple> mySortGeneric = new MySortGeneric<>();

        // Sort by weight in ascending order
        // Implementing a manual comparison
        mySortGeneric.sort(appleInventory, new MyComparatorGeneric<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                // Manual comparison without compareTo
                if (o1.getWeight() < o2.getWeight()) {
                    return -1;  // o1 is smaller
                } else if (o1.getWeight() > o2.getWeight()) {
                    return 1;   // o1 is larger
                } else {
                    return 0;   // they are equal
                }
            }
        });

        System.out.println("Print the list using the manual comparison" + appleInventory);



        System.out.println("\n 1. Keep your classes but replace anonymous classes with lambdas (quick win)\n");

        // Sort by weight in descending order
        // Implementing a manual comparison
        mySortGeneric.sort(appleInventory, (apple01, apple02) -> {

            // Manual comparison without compareTo
            if (apple01.getWeight() < apple02.getWeight()) {
                return 1;  // o1 is smaller
            } else if (apple01.getWeight() > apple02.getWeight()) {
                return -1;   // o1 is larger
            } else {
                return 0;   // they are equal
            }

           });

        System.out.println("Print the list using the manual comparison and lambda, descending order" + appleInventory);


        // Or even nicer (using autoboxing + compareTo):
        /**
         * compareTo(...) is not being used as a functional interface or as a lambda target.
         * It's being used as a normal method call inside the body of the lambda.
         */
        mySortGeneric.sort(appleInventory, (apple01, apple02) -> apple01.getWeight().compareTo(apple02.getWeight()));
        System.out.println("Print: Or even nicer (using autoboxing + compareTo)" + appleInventory);

        // Write this (cleaner & shorter):
        mySortGeneric.sort(appleInventory, (apple01, apple02) -> Integer.compare(apple01.getWeight(), apple02.getWeight()));
        System.out.println("Print the list using the Comparator.compare interface and lambda, ascending order" + appleInventory);







        System.out.println("\n 2. Recommended next step: drop MyComparatorGeneric and mySortGeneric → use the real Comparator" +
                " and List built-in sort method. \n");

        // Or better, this is the long lambda version:
        appleInventory.sort(Comparator.comparing((Apple apple) -> apple.getWeight()));
        System.out.println("Built-in List sort method plus Comparator, ascending order" + appleInventory);

        // Or better, this is the long lambda version:
        appleInventory.sort(Comparator.comparing(Apple::getWeight));
        System.out.println("Built-in List sort method plus Comparator, ascending order" + appleInventory);


        //Descending:
        appleInventory.sort(Comparator.comparing(Apple::getWeight, Comparator.reverseOrder()));
        System.out.println("Built-in List sort method plus Comparator, reverse order" + appleInventory);

        // Or shorter still (Java 8+):
        appleInventory.sort(Comparator.comparingInt(Apple::getWeight).reversed());
        System.out.println("Built-in List sort method plus Comparator, reverse order, shorter" + appleInventory);


        // Another way from the previous one
        appleInventory.sort(Comparator.comparing(Apple::getWeight).reversed());
        System.out.println("02 -Built-in List sort method plus Comparator, reverse order, shorter" + appleInventory);

        // Bonus: sort by color, then by weight
        appleInventory.sort(Comparator.comparing(Apple::getColor).thenComparing(Apple::getWeight));
        System.out.println("A chained sort, by color then by weight: " + appleInventory);


    }//Ends main method.


}
