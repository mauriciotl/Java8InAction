package lambdasinaction.chap1;

import java.util.*;
import java.util.function.Predicate;

public class FilteringApples{

    public static void main(String ... args){

        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                                              new Apple(155, "green"),
                                              new Apple(120, "red"));


        //Testing first attempt

        List<Apple> firstAttemptList = FilteringApples.filterGreenApplesFirstAttempt(inventory);
        System.out.println("The first attempt list: " + firstAttemptList);

        //Testing second attempt

        List<Apple> secondAttemptList = FilteringApples.filterApplesByColorSecondAttempt(inventory, "red");
        System.out.println("The second attempt list: " + secondAttemptList);



        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<Apple> greenApples = filterApples(inventory, FilteringApples::isGreenApple);
        System.out.println(greenApples);
        
        // [Apple{color='green', weight=155}]
        List<Apple> heavyApples = filterApples(inventory, FilteringApples::isHeavyApple);
        System.out.println(heavyApples);
        
        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<Apple> greenApples2 = filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
        System.out.println(greenApples2);
        
        // [Apple{color='green', weight=155}]
        List<Apple> heavyApples2 = filterApples(inventory, (Apple a) -> a.getWeight() > 150);
        System.out.println(heavyApples2);
        
        // []
        List<Apple> weirdApples = filterApples(inventory, (Apple a) -> a.getWeight() < 80 || 
                                                                       "brown".equals(a.getColor()));
        System.out.println(weirdApples);

    } //Ends main method.



    // 2.1.1. First attempt: filtering green apples, pag 38.
    public static List<Apple> filterGreenApplesFirstAttempt(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    // 2.1.2. Second attempt: parameterizing the color, pag 39
    public static List<Apple> filterApplesByColorSecondAttempt(List<Apple> inventory, String theColor){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if (theColor.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }


    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }



    //Some other filter methods

    public static List<Apple> filterHeavyApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor()); 
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }


    /**
     * The third attempt:
     *
     * 2.2. Behavior parameterization
     *
     * The third attempt is about using a Predicate, up to now it's this is very simmilar to
     * the Strategy pattern, except that a predicate is the following:
     *
     * We call this a predicate (that is, a function that returns a boolean).
     *
     */







    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }       

    public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color){
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            return "Apple{" +
                   "color='" + color + '\'' +
                   ", weight=" + weight +
                   '}';
        }
    }

}
