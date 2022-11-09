package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FirstTask {
    public static   List<Integer>getPositiveSort(int[]array){
      List<Integer> res =  getPositiveNumbers(array);
      res=sortDescend(res);
      return res;
    }
    public static List<Integer> getPositiveNumbers(int[]array)
    {
         List<Integer> positiveList=new ArrayList<>();
        for (int j : array) {
            if (j > 0) {
                positiveList.add(j);
            }
        }
         return positiveList;
    }
    public static List<Integer> sortDescend(List<Integer> list)
    {
      list.sort(Collections.reverseOrder());
      return list;
    }
}
