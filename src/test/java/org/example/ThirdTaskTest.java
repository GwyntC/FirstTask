package org.example;

import org.junit.jupiter.api.Test;
import org.shapes.Cube;
import org.shapes.Cylinder;
import org.shapes.IShape;
import org.shapes.Sphere;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ThirdTaskTest {
@Test
    void PositiveTest()
{
    //given
    IShape sphere=new Sphere(10);
    IShape cube= new Cube(10);
    IShape secondCube=new Cube(20.67);
    IShape cylinder=new Cylinder(10,20);
    ThirdTask task=new ThirdTask();
    List<IShape> shapes=new ArrayList<>();
    shapes.add(sphere);
    shapes.add(cube);
    shapes.add(cylinder);
    shapes.add(secondCube);
    //when
    List<IShape> sorted_res=task.sortShapes(shapes);
    List<IShape>sorted_expected=new ArrayList<>();
    sorted_expected.add(secondCube);
    sorted_expected.add(cylinder);
    sorted_expected.add(sphere);
    sorted_expected.add(cube);
    //then
    assertEquals(sorted_expected,sorted_res);
}
@Test
    void collectionIsNullTest()
{
    //given
    List<IShape> shapes=null;
    ThirdTask task=new ThirdTask();
    try
    {
        List<IShape> sorted_res=task.sortShapes(shapes);
        fail("Input collection is null");
    }
    catch(IllegalArgumentException e)
    {
        assertEquals("Input collection must not to be null",e.getMessage());
    }
}

    @Test
    void collectionIsEmptyTest()
    {
        //given
        List<IShape> shapes=new ArrayList<>();
        ThirdTask task=new ThirdTask();
        try
        {
            List<IShape> sorted_res=task.sortShapes(shapes);
            fail("Input collection is empty");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("Input collection must not to be empty",e.getMessage());
        }
    }

    @Test
    void collectionContainsNullTest()
    {
        //given
        IShape sphere=new Sphere(10);
        IShape cube= new Cube(10);
        IShape secondCube=new Cube(20.67);
        IShape cylinder= null;
        ThirdTask task=new ThirdTask();
        List<IShape> shapes=new ArrayList<>();
        shapes.add(sphere);
        shapes.add(cube);
        shapes.add(cylinder);
        shapes.add(secondCube);
        //then
        try
        {
            List<IShape> sorted_res=task.sortShapes(shapes);
            fail("Input collection contains null");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("Input collection must not contain nulls",e.getMessage());
        }
    }
@Test
    void shapeContainsNegativeValuesTest()
{
//given
    IShape sphere=new Sphere(-10);
    IShape cube= new Cube(10);
    IShape secondCube=new Cube(20.67);
    ThirdTask task=new ThirdTask();
    List<IShape> shapes=new ArrayList<>();
    shapes.add(sphere);
    shapes.add(cube);
    shapes.add(secondCube);
//then
    try
    {
        List<IShape> sorted_res=task.sortShapes(shapes);
        fail("Input collection contains wrong elements");
    }
    catch(IllegalArgumentException e)
    {
        assertEquals("Object must not have negative length",e.getMessage());
    }
    }
    @Test
    void shapeContainsZeroValuesTest()
    {
//given
        IShape sphere=new Sphere(0);
        IShape cube= new Cube(10);
        IShape secondCube=new Cube(20.67);
        ThirdTask task=new ThirdTask();
        List<IShape> shapes=new ArrayList<>();
        shapes.add(sphere);
        shapes.add(cube);
        shapes.add(secondCube);
//then
        try
        {
            List<IShape> sorted_res=task.sortShapes(shapes);
            fail("Input collection contains wrong elements");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("Object must not have 0 length",e.getMessage());
        }
    }
}
