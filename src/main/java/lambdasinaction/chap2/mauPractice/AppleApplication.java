package lambdasinaction.chap2.mauPractice;

import lambdasinaction.chap2.mauPractice.domain.Apple;
import lambdasinaction.chap2.mauPractice.domain.FilterApplesJava7;
import lambdasinaction.chap2.mauPractice.domain.FilterApplesPredicate;
import lambdasinaction.chap2.mauPractice.implementations.AppleGreen;
import lambdasinaction.chap2.mauPractice.implementations.AppleRedAndWeight;
import lambdasinaction.chap2.mauPractice.implementations.AppleWeight;
import lambdasinaction.chap2.mauPractice.interfaces.ApplePredicate;

import java.util.Arrays;
import java.util.List;

public class AppleApplication {


    public static void main(String ... args){

        List<Apple> appleInventory = Arrays.asList(
                new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        FilterApplesPredicate filterApplesPredicate = new FilterApplesPredicate();
        FilterApplesJava7 filterApplesJava7 = new FilterApplesJava7();


        /*
         * With classic java 7:
         */
        List<Apple> java7GreenApples = filterApplesJava7.filterApplesByColor(appleInventory, "red");
        System.out.println("Method, java7GreenApples(): " + java7GreenApples);


        /*
         * With java 8, Predicates:
         */

        List<Apple> java8GreenApples = filterApplesPredicate.filter(appleInventory, new AppleGreen());
        System.out.println("Method, java8GreenApples(): " + java8GreenApples);


        List<Apple> java8HeavyApples = filterApplesPredicate.filter(appleInventory, new AppleWeight());
        System.out.println("Method, java8HeavyApples(): " + java8HeavyApples);


        List<Apple> java8RedAndHeavyApples = filterApplesPredicate.filter(appleInventory, new AppleRedAndWeight());
        System.out.println("Method, java8RedAndHeavyApples(): " + java8RedAndHeavyApples);


        /**
         * THE FOLLOWING ONE IS VERY COOL,  we are passing the predicate interface and
         * creating the implementation in the same line:
         * 1. We are creating an instance of the interface and implementing its
         * 		abstract method, right there.
         *
         * 	So an appropriate name for the list variable should be aligned with the
         * 	filter or implementation that we are applying, in order that everything makes sense;
         * 	both the method's name and filter implementation.
         */

        List<Apple> java8RedApples = filterApplesPredicate.filter(appleInventory, new ApplePredicate()
            {
                @Override
                public boolean test(Apple apple) {
                    return apple.getColor().equals("red");
                }//Ends predicate method implementation.
            }//Ends the ApplePredicate class.
        );//Ends passing parameters to the filter method.

        System.out.println("Method, java8RedApples(): " + java8RedApples);


    }//Ends main method.



}
