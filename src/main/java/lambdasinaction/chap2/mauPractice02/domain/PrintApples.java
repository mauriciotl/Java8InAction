package lambdasinaction.chap2.mauPractice02.domain;

import lambdasinaction.chap2.mauPractice02.interfaces.AppleFormatter;

import java.util.List;

public class PrintApples {

    public void print(List<Apple> apples, AppleFormatter appleFormatter){

        for(Apple apple: apples){
            System.out.println(appleFormatter.format(apple));
        }
    }

}
