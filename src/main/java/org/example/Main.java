package org.example;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[][] lines={
                {"Mr","#Joy","#Jack","#Joy"},
                {"#Joy","#Jac","#Jack","#Jil","#Luce","#Sam"},
                {"#Joy","#Jack","#j"}
        };
        SecondTask task=new SecondTask();
        Map<String,Integer> res=task.getTopTags(task.getTags(lines));
        for (Map.Entry<String, Integer> entry : res.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }
    }
}