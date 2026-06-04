package lambdasinaction.chap3.mauPractice_ConstructorReferenceAndNewApple;

import lambdasinaction.chap3.mauPractice_ConstructorReferenceAndNewApple.Domain.AppleV02;
import lambdasinaction.chap3.mauPractice_ConstructorReferenceAndNewApple.Domain.Color;
import lambdasinaction.chap3.mauPractice_ConstructorReferenceAndNewApple.Util.CreateCompleteApple;
import lambdasinaction.chap3.mauPractice_ConstructorReferenceAndNewApple.Util.CreateSimpleApple;

public class AppConstructorReferenceV01 {

    //This application usess the predefined create apple implementations


    public static void main(String[] args) {

        //Create a simple apple
        CreateSimpleApple createSimpleAppleapple = new CreateSimpleApple();
        AppleV02 simpleApple = createSimpleAppleapple.get();
        simpleApple.setColor(Color.PURPLE);
        simpleApple.setWeight(90);
        System.out.println("The simple apple is: " + simpleApple);


        //Create a complete apple
        CreateCompleteApple createCompleteApple = new CreateCompleteApple();
        AppleV02 completeApple = createCompleteApple.apply(55, Color.RED);
        System.out.println("The complete apple is: " + completeApple);


    }



}
