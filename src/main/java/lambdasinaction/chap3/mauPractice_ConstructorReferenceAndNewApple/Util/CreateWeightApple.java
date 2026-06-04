package lambdasinaction.chap3.mauPractice_ConstructorReferenceAndNewApple.Util;

import lambdasinaction.chap3.mauPractice_ConstructorReferenceAndNewApple.Domain.AppleV02;

import java.util.function.Function;

public class CreateWeightApple implements Function<Integer, AppleV02> {

    @Override
    public AppleV02 apply(Integer weight) {
        return new AppleV02(weight);
    }
}
