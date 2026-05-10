package lambdasinaction.chap4.bookExample;

import java.util.*;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;


public class StreamBasic {

    public static void main(String...args){
        // Java 7
        getLowCaloricDishesNamesInJava7(Dish.menu).forEach(System.out::println);

        System.out.println("---");

        // Java 8
        getLowCaloricDishesNamesInJava8(Dish.menu).forEach(System.out::println);

    }

    public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes){

        //1. Select/filter low calories dishes => less than 400 calories and
        // add it into a new List
        List<Dish> lowCaloricDishes = new ArrayList<>();

        for(Dish d: dishes){
            if(d.getCalories() < 400){
                lowCaloricDishes.add(d);
            }
        }//Ends for

        //2. Sort ascendant
        lowCaloricDishes.sort(new Comparator<Dish>() {
            public int compare(Dish d1, Dish d2) {
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });

        //3. Add only the String name in a new List
        List<String> lowCaloricDishesName = new ArrayList<>();

        for(Dish d: lowCaloricDishes){
            lowCaloricDishesName.add(d.getName());
        }

        return lowCaloricDishesName;

    }//Ends method

    public static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes){
        return dishes.stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
    }
}
