package org.example;

import org.shapes.Shape;
import org.shapes.SortByVolume;

import java.util.Collections;
import java.util.List;

public class ThirdTask {
    public List<Shape> sortShapes(List<Shape> shapes) {
        if(shapes==null) {
            throw new IllegalArgumentException("Input collection must not to be null");
        } else if (shapes.size()==0) {
            throw new IllegalArgumentException("Input collection must not to be empty");
        } else if(shapes.contains(null)) {
            throw new IllegalArgumentException("Input collection must not contain nulls");
        }
        for(int i=0;i< shapes.size();i++) {
            if(shapes.get(i).getVolume()<0) {
                throw new IllegalArgumentException("Object must not have negative length");
            } else if (shapes.get(i).getVolume()==0) {
                throw new IllegalArgumentException("Object must not have 0 length");
            }
        }
        List <Shape> res=shapes;
        Collections.sort(res,Collections.reverseOrder(new SortByVolume()));
        return res;
    }
}
