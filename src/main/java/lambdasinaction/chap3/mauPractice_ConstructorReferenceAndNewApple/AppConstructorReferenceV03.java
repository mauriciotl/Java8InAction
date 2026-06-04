package lambdasinaction.chap3.mauPractice_ConstructorReferenceAndNewApple;

import lambdasinaction.chap3.mauPractice_ConstructorReferenceAndNewApple.Domain.AppleV02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class AppConstructorReferenceV03 {

    // Use the feature of creating an Apple a posteriory that given a list of
    // integers, representing the apple weight, create a list of Apples from this list
    // the method should be called map


    public static void main(String[] args) {

        // The weights list
        List<Integer> weights = Arrays.asList(7,3,4,10);

        // The map method blue print:

        System.out.println("The apple list is: " + map(weights, AppleV02::new));



    }


    public static List<AppleV02> map (List<Integer> weights, Function<Integer, AppleV02> f){

        List<AppleV02> apples = new ArrayList<>();

        for (Integer weight: weights){

            apples.add(f.apply(weight));

        }

        return apples;
    }


}
