package com.michaelssss;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Micha on 2017/4/20.
 */
public class MaxiumHeapTest {
    @Test
    public void testInsert() {
        MaxiumHeap maxiumHeap = new MaxiumHeap();
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int t : a) {
            maxiumHeap.insert(new LRUObject(t));
        }
        System.out.println(maxiumHeap);
    }

    @Test
    public void testGet() {
        MaxiumHeap maxiumHeap = new MaxiumHeap();
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int t : a) {
            maxiumHeap.insert(new LRUObject(t));
        }
        List list = new ArrayList();
        int i = 9;
        while (i-- > 0) {
            list.add(maxiumHeap.getMaxObject().getO());
        }
        System.out.println(list.toString());
    }
}
