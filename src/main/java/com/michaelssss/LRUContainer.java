package com.michaelssss;

import lombok.ToString;

/**
 * Created by Micha on 2017/4/20.
 */
@ToString
@SuppressWarnings("unchecked")
public class LRUContainer<T> {
    private int maxSize;
    private int nowSize;
    private MaxiumHeap maxiumHeap;

    public LRUContainer() {
        this.maxiumHeap = new MaxiumHeap();
        nowSize = 0;
    }

    public LRUContainer(int maxSize) {
        this();
        this.maxSize = maxSize;
    }

    public T get(T o) {
        return (T) maxiumHeap.peek(o).getO();
    }

    public void add(T o) {
        nowSize++;
        while (maxSize < nowSize - 1) {
            maxiumHeap.reduceMemory();
            nowSize--;
        }
        maxiumHeap.insert(new LRUObject(o));
    }

    public void delete(T t) {

    }
}
