package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


class FirstTaskTest {

    @Test
    void positiveTest() {
        //given
        int[] arr=new int []{1,2,3,4,5,6,7,8,8,-3,-5,-6,-7,-9};

        //when
        List<Integer>res=FirstTask.getPositiveSort(arr);

        //then
        assertEquals(Arrays.asList(8,8,7,6,5,4,3,2,1),res);
    }
    @Test
    void nullInputTest(){
        //given
        int[] arr=null;
        List<Integer> res= null;
        //when
        try {
             res = FirstTask.getPositiveSort(arr);
            fail("Null accepted");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("Array must be not null",e.getMessage());
        }
    }
    @Test
    void emptyArrayTest()
    {
        int[] arr={};
        List<Integer> res= new ArrayList<>();
        //when
        try {
            res = FirstTask.getPositiveSort(arr);
            fail("Empty accepted");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("Array must  not be  empty",e.getMessage());
        }

    }
}