package lambdasinaction.chap2.mauPractice.implementations;

import lambdasinaction.chap2.mauPractice.domain.Apple;
import lambdasinaction.chap2.mauPractice.interfaces.ApplePredicate;

public class AppleWeight implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
