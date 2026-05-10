package lambdasinaction.chap4.mauPractice02;

import lambdasinaction.chap4.bookExample.Dish;

import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PracticingAround {


    public static void main(String[] args) {

        // 1. Create a list of all the vegetarian dishes
        List<Dish> veggList = Dish.menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());

        veggList.forEach(System.out::println);

        // 2. Create a method/function that gets the list of all the vegetarian dishes, sorted base on the calories and
        // bring the tree most high calories.

        System.out.println("\nPrints the 3 most high calories dish on menu:");
        highestColoriesList(Dish.menu).forEach(System.out::println);


        // 3. Create same method as the previous one but get a list that prints the name of the
        // Dish and the calories number

        System.out.println("\nPrints the 3 most high calories dish on menu on a cool format:");
        veggMostHighCaloriesPrint(Dish.menu).forEach(System.out::println);


        // 3.1 another alternative is:
        System.out.println("\nPrints the 3 most high calories dish on menu on a cool format V02:");

        printList(Dish.menu);

    }//Ends main method


    public static List<Dish> highestColoriesList(List<Dish> disheList){

        return disheList.stream().filter(Dish::isVegetarian)
                .sorted(Comparator.comparing(Dish::getCalories).reversed()).limit(3)
                .collect(Collectors.toList());
    }


    public static List<String> veggMostHighCaloriesPrint(List<Dish> dishList){

        return dishList.stream().filter(Dish::isVegetarian)
                .sorted(Comparator.comparing(Dish::isVegetarian).reversed()).limit(3)
                .map(dish -> dish.getName() + " : " + dish.getCalories())
                .collect(Collectors.toList());
    }

    public static void printList(List<Dish> dishList){

        dishList.stream().filter(Dish::isVegetarian)
                .sorted(Comparator.comparing(Dish::getCalories).reversed())
                .limit(3)
                .forEach(dish -> System.out.println(dish.getName() + " -- " + dish.getCalories()));


    }

}//Ends class
