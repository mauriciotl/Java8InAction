package lambdasinaction.chap4.mauPractice;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MauStreamVsCollection {

    public static void main(String[] args) {

        List<String> mauList = Arrays.asList("surf", "music", "devOps", "girls", "playing the guitar");

        // Example 1
        System.out.println("--- Example 1");

        Stream<String> theMauStream = mauList.stream();
        theMauStream.sorted().forEach(System.out::println);

        System.out.println("--- ");

        // Example 2
        System.out.println("--- Example 2");

        Stream.of(mauList, mauList).forEach(System.out::println);

        // Option 1: Use mauList.stream() instead
        mauList.forEach(System.out::println);

        System.out.println("---");

        // Example 3
        System.out.println("--- Example 3");

        String[] stringArray = {"Mau", "Torres", "López"};
        Arrays.stream(stringArray).forEach(System.out::println);

        // A simplified version:
        System.out.println("--- Example 3, simplified version:");

        Arrays.stream(new String[] {"Mau", "Torres", "López"}).forEach(System.out::println);

    }

}
