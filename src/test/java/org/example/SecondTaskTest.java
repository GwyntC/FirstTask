package org.example;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


class SecondTaskTest {
@Test
    void positiveTest(){
    //given
    String[][] lines={
            {"Mr","#Joy","#Jack","#Joy"},
            {"#Joy","#Jac","#Jack","#Jil","#Luce","#Sam"},
            {"#Joy","#Jack","#j"}
    };
    SecondTask task=new SecondTask();
    Map<String,Integer> res=task.getTopTagsFromMap(task.getTags(lines));
    assertNotEquals(null,res);
}
@Test
    void nullArrayTest()
{
    //given
    String[][] lines=null;
    try {
        SecondTask task=new SecondTask();
        Map<String,Integer> res=task.getTopTagsFromMap(task.getTags(lines));
        fail("Null accepted");
    }
    catch(IllegalArgumentException e)
    {
        assertEquals("Array must not be null",e.getMessage());
    }
}
@Test
void emptyArrayTest()
{
    //given
    String[][] lines={};
    try {
        SecondTask task=new SecondTask();
        Map<String,Integer> res=task.getTopTagsFromMap(task.getTags(lines));
        fail("Empty array accepted");
    }
    catch(IllegalArgumentException e)
    {
        assertEquals("Array must not be empty",e.getMessage());
    }
}
@Test
void ArrayNoTagsTest(){
    //given
    String[][] lines={
            {"Mr","Joy","Jack","Joy"},
            {"Joy","Jac","Jack","Jil","Luce","Sam"},
            {"Joy","Jack","j"}
    };
    try {
        SecondTask task=new SecondTask();
        Map<String,Integer> res=task.getTopTagsFromMap(task.getTags(lines));
        fail("Array contains no tags");
    }
    catch(IllegalArgumentException e)
    {
        assertEquals("Array contains no tags",e.getMessage());
    }
}

@Test
 void ArrayOneTagTest()
 {
     //given
     String[][] lines= {
             {"Mr", "Joy", "Jack", "Joy"},
             {"Joy", "Jac", "Jack", "Jil", "Luce", "Sam"},
             {"Joy", "Jack", "#j"}
     };
     //when
             SecondTask task=new SecondTask();
     Map<String,Integer> res=task.getTopTagsFromMap(task.getTags(lines));
     String key = (String) res.keySet().toArray()[0];
     //then
     assertEquals("#j",key);
     assertEquals(1,res.get(key));

 }

    @Test
    void nullArrayElementTest()
    {
        //given
        String[][] lines= {
                {"Mr", "Joy", "Jack", "Joy"},
                {"Joy", "Jac", "Jack", null, "Luce", "Sam"},
                {"Joy", null, "#j"}
        };
        try {
            SecondTask task=new SecondTask();
            Map<String,Integer> res=task.getTopTagsFromMap(task.getTags(lines));
            fail("Null accepted");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("Array elements must not be null",e.getMessage());
        }
    }
}