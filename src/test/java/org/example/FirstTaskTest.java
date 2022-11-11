package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class FirstTaskTest {

    @Test
    public void positiveTest() {

            //given
            int[] arr=new int []{1,2,3,4,5,6,7,8,8,-3,-5,-6,-7,-9};
            //when
            List<Integer>res=FirstTask.getPositiveSort(arr);
            //then
            assertEquals(Arrays.asList(8,8,7,6,5,4,3,2,1),res);
    }

    @Test
    public void nullInputTest() {
        //given
        int[] arr=null;
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->{
                    //when
                    FirstTask.getPositiveSort(arr);
                        },
                        ("Allowed nulls"));
        //then
                assertEquals("Array must be not null",ex.getMessage());
    }

    @Test
   public void emptyArrayTest() {
        //given
        int[] arr={};
        List<Integer> res= new ArrayList<>();
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->{
                            //when
                            FirstTask.getPositiveSort(arr);
                        },
                        ("Allowed empty array"));
        //then
        assertEquals("Array must not be empty",ex.getMessage());
        }
    }