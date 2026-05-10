package lambdasinaction.chap2.mauPractice03_javaBuiltInPredicate;

import lambdasinaction.chap2.mauPractice02.domain.Apple;

import java.util.ArrayList;
import java.util.List;

public class AppUsingJavaBuiltInPredicate {


    public static void main(String[] args) {


        // The list db mocked:
        List<Apple> appleInventory = new ArrayList<>();
        appleInventory.add(new Apple(80, "green"));
        appleInventory.add(new Apple(155, "green"));
        appleInventory.add(new Apple(120, "red"));
        appleInventory.add(new Apple(99, "purple"));


        //Les than 100 weight

        List<Apple> theList = new ArrayList<>();
        theList = FilterPredicateSuperGeneric.
                filter(appleInventory, (apple -> apple.getWeight()<100 ));

        System.out.println("The apple list is: " + theList);

        theList = new ArrayList<>();
        theList = FilterPredicateSuperGeneric.
                filter(appleInventory, (apple -> apple.getWeight()<100
                        && apple.getColor().equals("green")));

        System.out.println("The apple complex list is: " + theList);


    }




}
