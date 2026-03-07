package lambdasinaction.chap2.mauPractice04_GenericsComparator;

import lambdasinaction.chap2.mauPractice04_GenericsComparator.domain.Apple;
import lambdasinaction.chap2.mauPractice04_GenericsComparator.domain.MySortGeneric;
import lambdasinaction.chap2.mauPractice04_GenericsComparator.interfaces.MyComparatorGeneric;

import java.util.ArrayList;
import java.util.List;

public class AppUseSortAndComparator {


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







        //Need to sort that previous list

        MySortGeneric<Apple> mySortGeneric_02 = new MySortGeneric<>();

        // Sort by weight in ascending order
        mySortGeneric_02.sort(appleInventory, new MyComparatorGeneric<Apple>() {
            @Override
            public int compare(Apple apple1, Apple apple2) {

                return apple1.getWeight().compareTo(apple2.getWeight());
            }
        });

        System.out.println(appleInventory);


        // Sort by weight in descending order
        mySortGeneric_02.sort(appleInventory, new MyComparatorGeneric<Apple>() {
            @Override
            public int compare(Apple apple1, Apple apple2) {

                return apple2.getWeight().compareTo(apple1.getWeight());
            }
        });

        System.out.println(appleInventory);







    }//Ends main method.


}
