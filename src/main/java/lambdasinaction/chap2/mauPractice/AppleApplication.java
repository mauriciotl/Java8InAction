package lambdasinaction.chap2.mauPractice;

import lambdasinaction.chap2.mauPractice.domain.Apple;
import lambdasinaction.chap2.mauPractice.util.FilterApplesUtil;
import lambdasinaction.chap2.mauPractice.util.FilterApplesUtilPredicate;
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
                new Apple(155, "blue"),
                new Apple(80, "blue"),
                new Apple(80, "purple"),
                new Apple(80, "purple"),
                new Apple(120, "red"));

        FilterApplesUtil filterApplesUtil = new FilterApplesUtil();
        FilterApplesUtilPredicate filterApplesUtilPredicate = new FilterApplesUtilPredicate();

        /*
         * Filer apples by color:
         */
        List<Apple> byColorApples = filterApplesUtil.filterApplesByColor(appleInventory, "red");
        System.out.println("Method, byColorApples(): " + byColorApples);


        /*
         * Filer apples by predicate, using predefined implementations:
         */

        List<Apple> byPredicatePredefinedGreenApples = filterApplesUtilPredicate.filter(appleInventory, new AppleGreen());
        System.out.println("Method, byPredicatePredefinedGreenApples(): " + byPredicatePredefinedGreenApples);


        List<Apple> byPredicatePredefinedWeightApples = filterApplesUtilPredicate.filter(appleInventory, new AppleWeight());
        System.out.println("Method, byPredicatePredefinedWeightApples(): " + byPredicatePredefinedWeightApples);


        List<Apple> byPredicatePredefinedWeightAndColorApples = filterApplesUtilPredicate.filter(appleInventory, new AppleRedAndWeight());
        System.out.println("Method, byPredicatePredefinedWeightAndColorApples(): " + byPredicatePredefinedWeightAndColorApples);


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

        List<Apple> redApples = filterApplesUtilPredicate.filter(appleInventory, new ApplePredicate()
            {
                @Override
                public boolean test(Apple apple) {
                    return apple.getColor().equals("red");
                }//Ends predicate method implementation.
            }//Ends the ApplePredicate class.
        );//Ends passing parameters to the filter method.

        System.out.println("Method, redApples(): " + redApples);

        System.out.println("=== FOLLOWINGS ARE USING LAMBDA ===");

        /**
         * Following examples for practicing chapter 3,
         * some examples using java 8 lambda expression
         *
         * This is inline implementation (using lambda syntax,
         * using a functional interface
         */


        List<Apple> appleRedByLambda = filterApplesUtilPredicate.filter(
                appleInventory, (Apple apple) -> apple.getColor().equals("red"));

        System.out.println("Using appleRedByLambda method: " + appleRedByLambda);

        /**
         * Check out why the following method reference will just not worK:
         *
         * https://gemini.google.com/app/d6213bdd40416a9c
         */

//        // Now using Java 8 Method reference syntax
//        List<Apple> appleRedByMethodReference = filterApplesUtilPredicate.filter(
//                appleInventory, Apple::getColor().equals("Red"));
//
//        System.out.println("Using appleRedByMethodReference method: " + appleRedByMethodReference);


        appleRedByLambda = filterApplesUtilPredicate.filter(
                appleInventory, (Apple apple) -> apple.getColor().equals("green") &&
                        apple.getWeight() > 150 );

        System.out.println("Using appleRedByLambda (now green and > 150 ) method: " + appleRedByLambda);

    }//Ends main method.



}
