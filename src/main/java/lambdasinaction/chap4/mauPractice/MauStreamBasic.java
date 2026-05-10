package lambdasinaction.chap4.mauPractice;

import lambdasinaction.chap4.bookExample.Dish;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class MauStreamBasic {


    public static void main(String[] args) {

        getLowCaloriesDishNamesInJava7(Dish.menu);

        for(String s : getLowCaloriesDishNamesInJava7(Dish.menu)){
            System.out.println(s);
        }

        // Another way to print is the following:
        getLowCaloriesDishNamesInJava7(Dish.menu).forEach(System.out::println);

        System.out.println(" --- ");

        getLowCaloriesDishNamesInJava8Baby(Dish.menu).forEach(System.out::println);

    }


    public static ArrayList<String> getLowCaloriesDishNamesInJava7(List<Dish> menu){

        // 1. Filter low calorie dishes
        ArrayList<Dish> lowCalorieDishes = new ArrayList<>();

        for(Dish dish: menu){
            if(dish.getCalories() < 400)
                lowCalorieDishes.add(dish);
        }

        // 2. Sort ascendant by calories
        lowCalorieDishes.sort(Comparator.comparing(Dish::getCalories));

        // 3. Add to String/Name list

        ArrayList<String> lowCalorieNames = new ArrayList<>();

        for (Dish lowDish : lowCalorieDishes){
            lowCalorieNames.add(lowDish.getName());
        }

        return lowCalorieNames;
    }



    public static List<String> getLowCaloriesDishNamesInJava8Baby (List<Dish> menu){

        return menu.stream()
                .filter(dish -> dish.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
    }



}
