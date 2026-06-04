package lambdasinaction.chap3.mauPractice_ConstructorReferenceAndNewApple.Util;

import lambdasinaction.chap3.mauPractice_ConstructorReferenceAndNewApple.Domain.AppleV02;

import java.util.function.Supplier;

public class CreateSimpleApple implements Supplier<AppleV02> {

    @Override
    public AppleV02 get() {
        return new AppleV02();
    }
}
