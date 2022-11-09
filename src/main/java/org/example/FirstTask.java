package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FirstTask {
    public  List<Integer>getPositiveSort(int[]array){
      List<Integer> res =  getPositiveNumbers(array);
      res=sortDescend(res);
      return res;
    }
    public List<Integer> getPositiveNumbers(int[]array)
    {
         List<Integer> positiveList=new ArrayList<>();
         for(int i=0;i< array.length;i++)
         {
             if(array[i]>0)
             {
                 positiveList.add((array[i]));
             }
         }
         return positiveList;
    }
    public List<Integer> sortDescend(List<Integer> list)
    {
      list.sort(Collections.reverseOrder());
      return list;
    }
}
