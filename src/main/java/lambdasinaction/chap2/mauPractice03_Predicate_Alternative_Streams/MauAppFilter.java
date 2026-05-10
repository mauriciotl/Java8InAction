package lambdasinaction.chap2.mauPractice03_Predicate_Alternative_Streams;

import lambdasinaction.chap2.mauPractice02.domain.Apple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MauAppFilter {

    public static void main(String[] args) {


        // The list db mocked:
        List<Apple> appleInventory = new ArrayList<>();
        appleInventory.add(new Apple(80, "green"));
        appleInventory.add(new Apple(155, "green"));
        appleInventory.add(new Apple(120, "red"));
        appleInventory.add(new Apple(99, "purple"));
        appleInventory.add(new Apple(70, "blue"));
        appleInventory.add(new Apple(100, "Deep blue"));


        List<Apple> filteredAppleList = appleInventory.stream()
                .filter(apple -> apple.getWeight() < 100)
                .collect(Collectors.toList());

        System.out.println("The filtered apple list is: " + filteredAppleList);


        filteredAppleList = appleInventory.stream()
                .filter(apple -> apple.getWeight() < 120
                && apple.getColor().contains("u"))
                .sorted(Comparator.comparing(Apple::getWeight).reversed())
                .collect(Collectors.toList());

        System.out.println("The filtered apple list is: " + filteredAppleList);


    }//Ends main

}//Ends class
