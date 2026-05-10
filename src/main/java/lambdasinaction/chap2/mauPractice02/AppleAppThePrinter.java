package lambdasinaction.chap2.mauPractice02;

import lambdasinaction.chap2.mauPractice02.domain.Apple;
import lambdasinaction.chap2.mauPractice02.domain.PrintApples;
import lambdasinaction.chap2.mauPractice02.implementation.AppleHeavyOrLight;
import lambdasinaction.chap2.mauPractice02.interfaces.AppleFormatter;

import java.net.StandardSocketOptions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppleAppThePrinter {

    public static void main(String[] args){

        List<Apple> appleInventory = new ArrayList<>();
        appleInventory.add(new Apple(80, "green"));
        appleInventory.add(new Apple(155, "green"));
        appleInventory.add(new Apple(120, "red"));


        PrintApples printApples = new PrintApples();
        printApples.print(appleInventory, new AppleHeavyOrLight());

        //The following example using an anonymous class to create
        //an inline implementation.
        printApples.print(appleInventory, new AppleFormatter() {
            @Override
            public String format(Apple apple) {
                return apple.getColor().equals("red") ? "Cool it's a red apple" : "Not a red apple";
            }
        });


        System.out.println("The following is a Mau practice: ");
        printApples.print(appleInventory, new AppleFormatter() {
            @Override
            public String format(Apple apple) {
                return apple.getWeight() > 100 ? "This is a heavy apple: " + apple.getWeight()
                        : "not a heavy apple: " + apple.getWeight();
            }
        });


        /**
         * The following example uses Lambdas from chapter 3
         */

        PrintApples printerApples = new PrintApples();

        System.out.println("\nThe following is a lambda implementation: By Mau practicing ");
        printerApples.print(appleInventory, apple -> apple.getColor().equals("red")?
                "It's a red apple" : "not a red apple");

        System.out.println("\nThe following is using method reference");
        printerApples.print(appleInventory, Apple::toString);

        System.out.println("\nThe following is a lambda implementation: ");
        printerApples.print(appleInventory, (Apple apple)-> "The color of this apple by lambda method: " + apple.getColor());




    }//Ends main
}
