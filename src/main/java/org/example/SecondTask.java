package org.example;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SecondTask {
    public Map<String,Integer> getTopTagsFromArr(String[][] lines)
    {
        Map<String,Integer> top_five=getTags(lines);
        top_five=getTopTagsFromMap(top_five);
        return top_five;
    }
    public Map<String,Integer> getTags(String[][] lines){
        if(lines==null)
        {
            throw new IllegalArgumentException("Array must not be null");
        } else if (lines.length==0) {
            throw new IllegalArgumentException("Array must not be empty");
        }
        int row_num=-1;
        Map<String,Integer> tags= new HashMap<>();
        for(int i=0;i< lines.length;i++){
            for(int j=0;j<lines[i].length;j++)
            {
                if(lines[i][j]==null)
                {
                    throw new IllegalArgumentException("Array elements must not be null");
                }
                if(lines[i][j].charAt(0)=='#')
                {
                    if(!tags.containsKey(lines[i][j]))
                    {
                        tags.put(lines[i][j],1);
                        row_num=i;
                    }
                    else if (tags.containsKey(lines[i][j])) {
                        if(i!=row_num)
                        {
                            tags.put(lines[i][j],tags.get(lines[i][j])+1);
                        }
                    }
                }
            }
        }
        return tags;
    }
    public  Map<String,Integer> getTopTagsFromMap(Map<String,Integer> map)
    {
        if(map.size()==0)
        {
            throw new IllegalArgumentException("Array contains no tags");
        }
        Map<String,Integer> top_five=
                map.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .limit(5)
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1,e2) -> e1, LinkedHashMap::new));
        return top_five;
    }
}
