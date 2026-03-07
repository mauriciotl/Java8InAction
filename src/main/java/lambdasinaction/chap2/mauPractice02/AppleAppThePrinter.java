package lambdasinaction.chap2.mauPractice02;

import lambdasinaction.chap2.mauPractice02.domain.Apple;
import lambdasinaction.chap2.mauPractice02.domain.PrintApples;
import lambdasinaction.chap2.mauPractice02.implementation.AppleHeavyOrLight;
import lambdasinaction.chap2.mauPractice02.interfaces.AppleFormatter;

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





    }//Ends main
}
