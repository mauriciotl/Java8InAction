package lambdasinaction.chap2.mauPractice02.implementation;

import lambdasinaction.chap2.mauPractice02.domain.Apple;
import lambdasinaction.chap2.mauPractice02.interfaces.AppleFormatter;

public class AppleHeavyOrLight implements AppleFormatter {


    @Override
    public String format(Apple apple) {

        //The following return, using a Ternary Operator or Conditional Operator.
        return apple.getWeight() >= 140 ?
                "This is a heavy apple: " + apple.getWeight().toString() :
                "This is a light apple: " + apple.getWeight().toString();
    }
}
