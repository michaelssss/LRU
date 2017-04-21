package com.michaelssss;

import org.junit.Test;

/**
 * Created by Micha on 2017/4/20.
 */
public class LRUContainerTest {
    @Test
    public void add() {
        LRUContainer<Integer> lruContainer = new LRUContainer<>(5);
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int t : a) {
            lruContainer.add(t);
        }
        lruContainer.get(9);
        lruContainer.get(9);
        lruContainer.get(9);
        lruContainer.get(8);
        System.out.println(lruContainer);
    }
}
