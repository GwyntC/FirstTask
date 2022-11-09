package org.example;

import java.util.HashMap;
import java.util.Map;

public class SecondTask {
    public Map<String,Integer> getTags(String[][] lines){
        int row_num=-1;
        Map<String,Integer> tags=new HashMap<String,Integer>();
        for(int i=0;i< lines.length;i++){
            for(int j=0;j<lines[i].length;j++)
            {
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
    public  Map<String,Integer> getTopTags(Map<String,Integer> map)
    {
        Map<String,Integer> top_tags=new HashMap<String,Integer>();
        return top_tags;
    }
}
