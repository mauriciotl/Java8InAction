package lambdasinaction.chap2.mauPractice04_MauGenericComparator;

import java.util.ArrayList;
import java.util.List;

public class MauSortApp {

    public static void main(String[] args) {


        List<Apple> appleInventory = new ArrayList<>();
        appleInventory.add(new Apple(80, "green"));
        appleInventory.add(new Apple(155, "green"));
        appleInventory.add(new Apple(120, "red"));
        appleInventory.add(new Apple(90, "fluorescent"));

        System.out.println("The original list is: " + appleInventory.toString() + "\n");

        //Need to sort that previous list

        SorterMau<Apple> sorterMau = new SorterMau<>();

        sorterMau.sort(appleInventory, new ComparatorMau<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {

                if(a1.getWeight() > a2.getWeight()){
                    return 1;
                } else if (a1.getWeight() < a2.getWeight()) {
                    return -1;
                }else {
                    return 0;
                }
            }
        });

        System.out.println("The sorted list by weight is: " + appleInventory.toString() + "\n");


        //A simplified version from the previous one is:

        sorterMau.sort(appleInventory, new ComparatorMau<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {

                return a1.getWeight().compareTo(a2.getWeight());
            }
        });

        System.out.println("The sorted list by weight is (simplified imp): " + appleInventory.toString() + "\n");


        //Now order by color descending order

        sorterMau.sort(appleInventory, new ComparatorMau<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a2.getColor().compareTo(a1.getColor());
            }
        });

        System.out.println("The sorted list by Color (Descending order): " + appleInventory.toString() + "\n");


        //Now order by color ascending order using lambda exp (Anonymous inline function)

        sorterMau.sort(appleInventory, (a1, a2) -> a1.getColor().compareTo(a2.getColor()));

        System.out.println("The sorted list by Color (Asc order) using lambda exp: " + appleInventory.toString() + "\n");


    }//Ends main method

}// Ends class
