package lambdasinaction.chap2.mauPractice04_MauGenericComparator;

import java.util.ArrayList;
import java.util.List;

public class SorterMau <T> {


    public  List<T> sort(List<T> list, ComparatorMau<T> c){

        int n = list.size();
        boolean swapped;

        // Bubble sort
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                T current = list.get(j);
                T next = list.get(j + 1);

                if (c.compare(current, next) > 0) {
                    // Swap
                    list.set(j, next);
                    list.set(j + 1, current);
                    swapped = true;
                }
            }
            // Optimization: stop if no swaps happened
            if (!swapped) break;
        }//Ends for

        return list;

    }//Ends method


}
