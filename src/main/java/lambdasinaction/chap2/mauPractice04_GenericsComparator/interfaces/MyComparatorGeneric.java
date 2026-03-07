package lambdasinaction.chap2.mauPractice04_GenericsComparator.interfaces;

import lambdasinaction.chap2.mauPractice04_GenericsComparator.domain.Apple;

public interface MyComparatorGeneric<T>{

    int compare(T o1, T o2);

}
