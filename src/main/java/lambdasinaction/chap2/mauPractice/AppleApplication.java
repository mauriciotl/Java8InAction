package lambdasinaction.chap2.mauPractice;

import lambdasinaction.chap2.mauPractice.domain.Apple;
import lambdasinaction.chap2.mauPractice.domain.FilterApplesJava7;
import lambdasinaction.chap2.mauPractice.domain.FilterApplesPredicate;
import lambdasinaction.chap2.mauPractice.implementations.AppleGreen;
import lambdasinaction.chap2.mauPractice.implementations.AppleRedAndWeight;
import lambdasinaction.chap2.mauPractice.implementations.AppleWeight;
import lambdasinaction.chap2.mauPractice.interfaces.ApplePredicate;

import java.util.ArrayList;
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
         * Still Java 7 but using: predicates:
         */

        List<Apple> java8GreenApples = filterApplesPredicate.filter(appleInventory, new AppleGreen());
        System.out.println("Method, java8GreenApples(): " + java8GreenApples);


        List<Apple> java8HeavyApples = filterApplesPredicate.filter(appleInventory, new AppleWeight());
        System.out.println("Method, java8HeavyApples(): " + java8HeavyApples);


        List<Apple> java8RedAndHeavyApples = filterApplesPredicate.filter(appleInventory, new AppleRedAndWeight());
        System.out.println("Method, java8RedAndHeavyApples(): " + java8RedAndHeavyApples);


        /**
         * THE FOLLOWING ONE IS VERY COOL,  we are passing the predicate interface and
         * inline implementation, using and anonymous class.
         * 1. We are creating an instance of the interface and implementing its
         * 		abstract method, right there.
         *
         * 	So an appropriate name for the filter-list variable should be aligned with the
         * 	filter or implementation that we are applying, in order that everything makes sense;
         * 	both the method's name and filter implementation.
         *
         * 	The part new ApplePredicate() { ... } is an anonymous class.
         *  It creates an unnamed (anonymous) class that implements the ApplePredicate interface right
         *  at the place where it's used.
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

        System.out.println("=== FOLLOWINGS ARE USING LAMBDA ===");

        /**
         * Following examples for practicing chapter 3,
         * some examples using java 8 lambda expression
         *
         * This is inline implementation (using lambda syntax,
         * using a functional interface
         */

        FilterApplesPredicate filterApplesPredicate02 = new FilterApplesPredicate();

        List<Apple> appleRedByLambda = filterApplesPredicate02.filter(
                appleInventory, (Apple apple) -> apple.getColor().equals("red"));

        System.out.println("Using appleRedByLambda method: " + appleRedByLambda);

//        // Now using Java 8 Method reference syntax
//        List<Apple> appleRedByLambdaMR = filterApplesPredicate02.filter(
//                appleInventory, Apple::getColor());

//        System.out.println("Using appleRedByLambdaMR method: " + appleRedByLambdaMR);

//        filterApplesPredicate02 = new FilterApplesPredicate();

        appleRedByLambda = filterApplesPredicate02.filter(
                appleInventory, (Apple apple) -> apple.getColor().equals("green") &&
                        apple.getWeight() > 150 );

        System.out.println("Using appleRedByLambda (now green and > 150 ) method: " + appleRedByLambda);

    }//Ends main method.



}
