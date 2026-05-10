package lambdasinaction.chap4.bookExample;

import java.util.*;
import java.util.stream.*;


public class StreamVsCollection {

    public static void main(String...args){
        List<String> names = Arrays.asList("Java8", "Lambdas", "In", "Action");

        // The following operation not allowed in this type of data structure
        // Why is it then available in the IDE?
//        names.add("mau");


        Stream<String> s = names.stream();
        s.forEach(System.out::println);
        // uncommenting this line will result in an IllegalStateException
        // because streams can be consumed only once
//        s.forEach(System.out::println);
    }
}