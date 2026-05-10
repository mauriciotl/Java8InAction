package lambdasinaction.chap3.mauPractice_consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class AppConsumer {


    public static void main(String[] args) {

        forEachMau(Arrays.asList(1, 2, 3, 4, 5, 6), new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        System.out.println("Approach 2:");

        forEachMau(Arrays.asList(1, 2, 3, 4, 5, 6), integer -> System.out.println(integer));

        System.out.println("\nApproach 3:");

        forEachMau(Arrays.asList(1, 2, 3, 4, 5, 6), System.out::println);

        System.out.println("\nThe out of the box Approach, using the forEch built-in implementation:");
        Arrays.asList(1,2,3,4,5).forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        System.out.println("\nThe out of the box Approach, using the forEch built-in implementation in Arrays:");
        System.out.println("now using lambda exp");
        Arrays.asList(1,2,3,4,5).forEach(System.out::println);

    }



    //Following is the application method.

    public static <T> void forEachMau (List<T> list, Consumer<T> c){

        for(T t : list){
            c.accept(t);
        }
    }


}
