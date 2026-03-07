package lambdasinaction.chap2.mauPractice02.implementation;

import lambdasinaction.chap2.mauPractice02.domain.Apple;
import lambdasinaction.chap2.mauPractice02.interfaces.AppleFormatter;

public class AppleWeight implements AppleFormatter {
    @Override
    public String format(Apple apple) {

        return "The apple weight is: " + apple.getWeight().toString();
    }
}
