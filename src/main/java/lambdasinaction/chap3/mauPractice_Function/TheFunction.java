package lambdasinaction.chap3.mauPractice_Function;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TheFunction {


    public static void main(String[] args) {


        // The actual use of the application method
        // Give a list of String, return a list of ech length,
        // additionally print it

        List<Integer> integers = map(Arrays.asList("lambdas", "in", "action"), (String s) -> s.length());
        System.out.println(integers);

        System.out.println(" Example 02 ------- \n");

        List<Integer> integers02 = map(Arrays.asList("lambdas", "in", "action"), String::length);
        System.out.println("\n The list by method reference");
        System.out.println(integers02);

        System.out.println(" Example 03  sorting ( theList.sort(Comparator.naturalOrder() and Collections.sort(theList)------- \n");

        integers02 = map(Arrays.asList("lambdas", "in", "action"), String::length);
        integers02.sort(Comparator.naturalOrder());
        System.out.println(integers02);

        Collections.sort(integers02);           // limited sorting
        System.out.println(integers02);


        System.out.println(" Example 04, using lambdas baby!! ------- \n");


        List<Integer> integers04 = map(Arrays.asList("lambdas", "in", "action"), String::length)
                .stream().sorted().collect(Collectors.toList());

        System.out.println(integers04);

        System.out.println(" Same in reversed order ------- \n");

        List<Integer> integers05 = map(Arrays.asList("lambdas", "in", "action"), String::length)
                .stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        System.out.println(integers05);

    }


    // The function interface: I'm using the Java built-in interface
    // ( Uses two types, its method apply() receive one type (T) , return another type (R) )

    // The generic application method (map)
    // As parameter receive one list type T, plus the interface
    // The internal process is about taking type T extract information about it
    //  and add that value to a new list<R>

    public static <T, R> List<R> map(List<T> list, Function<T,R> f){

        List<R> newList = new ArrayList<>();

        for(T t : list){
            newList.add(f.apply(t));
        }

        return newList;
    }







}
