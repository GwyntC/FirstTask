package org.example;

import org.junit.jupiter.api.Test;
import org.shapes.Cube;
import org.shapes.Cylinder;
import org.shapes.Shape;
import org.shapes.Sphere;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ThirdTaskTest {

    @Test
    public void PositiveTest() {
        //given
        Shape sphere = new Sphere(10);
        Shape cube = new Cube(10);
        Shape secondCube = new Cube(20.67);
        Shape cylinder = new Cylinder(10, 20);
        ThirdTask task = new ThirdTask();
        List<Shape> shapes = new ArrayList<>();
        shapes.add(sphere);
        shapes.add(cube);
        shapes.add(cylinder);
        shapes.add(secondCube);
        //when
        List<Shape> sorted_res = task.sortShapes(shapes);
        List<Shape> sorted_expected = new ArrayList<>();
        sorted_expected.add(secondCube);
        sorted_expected.add(cylinder);
        sorted_expected.add(sphere);
        sorted_expected.add(cube);
        //then
        assertEquals(sorted_expected, sorted_res);
    }

    @Test
    public void collectionIsNullTest() {
        //given
        List<Shape> shapes = null;
        ThirdTask task = new ThirdTask();
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
                    //when
                    List<Shape> sorted_res = task.sortShapes(shapes);
                },
                ("Allowed empty collection"));
        //then
        assertEquals("Input collection must not to be null", ex.getMessage());

    }

    @Test
    public void collectionIsEmptyTest() {
        //given
        List<Shape> shapes = new ArrayList<>();
        ThirdTask task = new ThirdTask();
        //when
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
                    //when
                    List<Shape> sorted_res = task.sortShapes(shapes);
                },
                ("Allowed empty collection"));
        //then
        assertEquals("Input collection must not to be empty", ex.getMessage());
    }

    @Test
    public void collectionContainsNullTest() {
        //given
        Shape sphere = new Sphere(10);
        Shape cube = new Cube(10);
        Shape secondCube = new Cube(20.67);
        Shape cylinder = null;
        ThirdTask task = new ThirdTask();
        List<Shape> shapes = new ArrayList<>();
        shapes.add(sphere);
        shapes.add(cube);
        shapes.add(cylinder);
        shapes.add(secondCube);
        //when
        IllegalArgumentException ex =
                assertThrows(IllegalArgumentException.class, () -> {
                            //when
                            List<Shape> sorted_res = task.sortShapes(shapes);
                        },
                        ("Allowed null shape"));
        //then
        assertEquals("Input collection must not contain nulls", ex.getMessage());
    }

    @Test
    public void shapeContainsNegativeValuesTest() {
        //given
        Shape sphere = new Sphere(-10);
        Shape cube = new Cube(10);
        Shape secondCube = new Cube(20.67);
        ThirdTask task = new ThirdTask();
        List<Shape> shapes = new ArrayList<>();
        shapes.add(sphere);
        shapes.add(cube);
        shapes.add(secondCube);

        IllegalArgumentException ex =
                assertThrows(IllegalArgumentException.class, () -> {
                            //when
                            List<Shape> sorted_res = task.sortShapes(shapes);
                        },
                        ("Allowed shape negative size"));
        //then
        assertEquals("Object must not have negative length", ex.getMessage());
    }

    @Test
    public void shapeContainsZeroValuesTest() {
//given
        Shape sphere = new Sphere(0);
        Shape cube = new Cube(10);
        Shape secondCube = new Cube(20.67);
        ThirdTask task = new ThirdTask();
        List<Shape> shapes = new ArrayList<>();
        shapes.add(sphere);
        shapes.add(cube);
        shapes.add(secondCube);
//when
        IllegalArgumentException ex =
                assertThrows(IllegalArgumentException.class, () -> {
                            //when
                            List<Shape> sorted_res = task.sortShapes(shapes);
                        },
                        ("Allowed zero values shape"));
        //then
        assertEquals("Object must not have 0 length", ex.getMessage());
    }
}
