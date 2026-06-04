package lambdasinaction.chap3.mauPractice_ConstructorReferenceAndNewApple;

import lambdasinaction.chap3.mauPractice_ConstructorReferenceAndNewApple.Domain.AppleV02;
import lambdasinaction.chap3.mauPractice_ConstructorReferenceAndNewApple.Domain.Color;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class AppConstructorReferenceV02 {

    // This application uses  inline implementations rather than prebuilt ones.

    public static void main(String[] args) {


        // Blueprint to create a simple apple

//        Supplier<AppleV02> constructorSimpleApple = () -> new AppleV02(); //Using lambda expression
        Supplier<AppleV02> constructorSimpleApple = AppleV02::new;

        // The actual creation of the Apple
        AppleV02 simpleApple = constructorSimpleApple.get();
        System.out.println("The simple apple is: " + simpleApple);


        // Blueprint to create a complete apple

//        BiFunction<Integer, Color, AppleV02> constructorCompleteApple =
//                (weight, color) -> new AppleV02(weight, color);  //This is using lambda expression.

        BiFunction<Integer, Color, AppleV02> constructorCompleteApple = AppleV02::new;

        //The actual creation of the complete apple:
        AppleV02 completeApple = constructorCompleteApple.apply(112, Color.RED);

        System.out.println("The complete apple is: " + completeApple);


    }


}
