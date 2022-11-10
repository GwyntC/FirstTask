package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


class SecondTaskTest {
    @Test
    public void positiveTest() {
        //given
        List<String> lines = Arrays.asList("#jim john", "#jack");
        SecondTask task = new SecondTask();
        //when
        Map<String, Integer> res = task.getTopTagsFromMap(task.getTags(lines));
        //then
        assertNotEquals(null, res);
    }

    @Test
    public void nullArrayTest() {
        //given
        List<String> lines = null;
        SecondTask task = new SecondTask();
        //when
        IllegalArgumentException ex =
                assertThrows(IllegalArgumentException.class, () -> {
                            //when
                            task.getTopTagsFromArr(lines);
                        },
                        ("Allowed null as list"));
        //then
        assertEquals("List must not be null", ex.getMessage());
    }

    @Test
    public void emptyArrayTest() {
        List<String> lines = new ArrayList<>();
        SecondTask task = new SecondTask();
        //when
        IllegalArgumentException ex =
                assertThrows(IllegalArgumentException.class, () -> {
                            //when
                            task.getTopTagsFromArr(lines);
                        },
                        ("Allowed empty list as list"));
        //then
        assertEquals("List must not be empty", ex.getMessage());
    }

    @Test
    public void ArrayNoTagsTest() {
        //given
        List<String> lines = Arrays.asList("jim john", "jack jack", "ack");
        SecondTask task = new SecondTask();
        //when
        IllegalArgumentException ex =
                assertThrows(IllegalArgumentException.class, () -> {
                            //when
                            task.getTopTagsFromArr(lines);
                        },
                        ("Allowed list without tags"));
        //then
        assertEquals("List contains no tags", ex.getMessage());
    }

    @Test
    public void ArrayOneTagTest() {
        //given
        List<String> lines = Arrays.asList("jim john", "#jack jack", "ack");
        SecondTask task = new SecondTask();
        //when
        Map<String, Integer> res = task.getTopTagsFromMap(task.getTags(lines));
        String key = (String) res.keySet().toArray()[0];
        //then
        assertEquals("#jack", key);
        assertEquals(1, res.get(key));

    }

    @Test
    public void nullArrayElementTest() {
        //given
        List<String> lines = Arrays.asList("jim john", null, "ack");
        SecondTask task = new SecondTask();
        //when
        IllegalArgumentException ex =
                assertThrows(IllegalArgumentException.class, () -> {
                            task.getTopTagsFromArr(lines);
                        },
                        ("Allowed null element"));
        //then
        assertEquals("List element must not be null", ex.getMessage());
    }
}