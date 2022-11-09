package org.example;

import org.shapes.IShape;
import org.shapes.SortByVolume;

import java.util.Collections;
import java.util.List;

public class ThirdTask
{
    public List<IShape> sortShapes(List<IShape> shapes)
    {
        List <IShape> res=shapes;
        Collections.sort(res,new SortByVolume());
        return res;
    }
}
