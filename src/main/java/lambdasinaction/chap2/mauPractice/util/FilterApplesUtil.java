package lambdasinaction.chap2.mauPractice.util;

import lambdasinaction.chap2.mauPractice.domain.Apple;

import java.util.ArrayList;
import java.util.List;

public class FilterApplesUtil {

    // This class uses Apple, does not have Apple, pure functionality.

    //**********************************************************
    // The following are classic Java 7 methods.
    //**********************************************************

    public List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory){
            if("green".equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }

    public List<Apple> filterApplesByColor(List<Apple> inventory, String color){
        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory){
            if(apple.getColor().equals(color)){
                result.add(apple);
            }
        }
        return result;
    }

    public List<Apple> filterApplesByWeight(List<Apple> inventory, int weight){
        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory){
            if(apple.getWeight() > weight){
                result.add(apple);
            }
        }
        return result;
    }



}
