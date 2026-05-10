package lambdasinaction.chap2.mauPractice04_MauBuilt_In_Comparator;

import lambdasinaction.chap2.mauPractice04_MauGenericComparator.Apple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MauSortApp02 {


    public static void main(String[] args) {

        List<Apple> appleInventory = new ArrayList<>();
        appleInventory.add(new Apple(80, "green"));
        appleInventory.add(new Apple(155, "green"));
        appleInventory.add(new Apple(155, "red"));
        appleInventory.add(new Apple(120, "red"));
        appleInventory.add(new Apple(120, "blue"));
        appleInventory.add(new Apple(80, "fluorescent"));
        appleInventory.add(new Apple(120, "fluorescent"));

        System.out.println("The original list is: " + appleInventory.toString() + "\n");


        //Need to sort that previous list

        SorterMau02<Apple> sorter02 = new SorterMau02<>();

        sorter02.sort(appleInventory, new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });

        System.out.println("The sorted list by weight is: " + appleInventory.toString() + "\n");


        //A simplified version from the previous one is:

        sorter02.sort(appleInventory,
                (a1, a2) -> a2.getWeight().compareTo(a1.getWeight()));

        System.out.println("The sorted list by weight (descending and by lambda exp) is: " + appleInventory.toString() + "\n");



        //A simplified version from the previous one is:

        sorter02.sort(appleInventory, Comparator.comparing(Apple::getWeight));

        System.out.println("The sorted list by weight (asc order, using method reference) is: " + appleInventory.toString() + "\n");

        // =========================
        // Using the Java built in Collections.sort(), baby!!
        // =========================

        Collections.sort(appleInventory, Comparator.comparing(Apple::getWeight).reversed());

        System.out.println("Using the Java built-in Collections.sort(): " + appleInventory.toString() + "\n");

        // =========================
        // Using the Java built in List.sort(), baby!!
        // =========================

        appleInventory.sort(Comparator.comparing(Apple::getWeight));

        System.out.println("Using the Java built-in list.sort(): " + appleInventory.toString() + "\n");


        //A chain comparison:

        appleInventory.sort(Comparator.comparing(Apple::getWeight).thenComparing(Apple::getColor));

        System.out.println("Using the Java built-in list.sort() by weight then by color: " + appleInventory.toString() + "\n");




    }// Ends main method


}
