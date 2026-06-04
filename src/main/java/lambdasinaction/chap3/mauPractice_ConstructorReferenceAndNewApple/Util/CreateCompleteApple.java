package lambdasinaction.chap3.mauPractice_ConstructorReferenceAndNewApple.Util;

import lambdasinaction.chap3.mauPractice_ConstructorReferenceAndNewApple.Domain.AppleV02;
import lambdasinaction.chap3.mauPractice_ConstructorReferenceAndNewApple.Domain.Color;

import java.util.function.BiFunction;

public class CreateCompleteApple implements BiFunction<Integer, Color, AppleV02> {

    @Override
    public AppleV02 apply(Integer weight, Color color) {
        return new AppleV02(weight, color);
    }

}
