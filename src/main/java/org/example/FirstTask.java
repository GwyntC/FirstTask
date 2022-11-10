package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstTask {
    public static List<Integer> getPositiveSort(int[] array) {
        List<Integer> res = getPositiveNumbers(array);
        res = sortDescend(res);
        return res;
    }

    public static List<Integer> getPositiveNumbers(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array must be not null");
        } else if (array.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }
        List<Integer> positiveList = Arrays.stream(array)
                .boxed()
                .filter(x -> x > 0)
                .collect(Collectors.toList());
        return positiveList;
    }

    public static List<Integer> sortDescend(List<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("List must be not null");
        } else if (list.size() == 0) {
            throw new IllegalArgumentException("List must  not be  empty");
        }
        list.sort(Collections.reverseOrder());
        return list;
    }
}
