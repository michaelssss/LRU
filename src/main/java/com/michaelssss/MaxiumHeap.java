package com.michaelssss;

import lombok.ToString;

import java.util.Arrays;

/**
 * Created by Micha on 2017/4/20.
 */
@ToString
public class MaxiumHeap {
    private LRUObject[] heap;

    public MaxiumHeap() {
        heap = new LRUObject[1];
    }

    public LRUObject getMaxObject() {
        LRUObject lruObject = heap[1];
        delete();
        return lruObject;
    }

    public void reduceMemory() {
        delete();
    }

    public LRUObject peek(Object o) {
        LRUObject lruObject = null;
        for (int i = 1; i < heap.length; i++) {
            if (heap[i].equals(o)) {
                lruObject = heap[i];
                buildMinHeap();
            }
        }
        return lruObject;
    }

    public void insert(LRUObject object) {
        expandContainer();
        heap[heap.length - 1] = object;
        buildMinHeap();
    }

    private void delete() {
        LRUObject[] tmp = new LRUObject[heap.length - 1];
        heap[1] = null;
        System.arraycopy(heap, 1, tmp, 0, heap.length - 1);
        heap = tmp;
        buildMinHeap();
    }

    private void buildMinHeap() {
        int node = heap.length - 1;
        while (node / 2 != 0) {
            int parent = node / 2;
            int right = parent * 2 + 1;
            int left = parent * 2;
            if (isRightExist(parent)) {
                LRUObject[] tmp = {heap[parent], heap[left], heap[right]};
                Arrays.sort(tmp);
                heap[parent] = tmp[0];
                heap[left] = tmp[1];
                heap[right] = tmp[2];
            } else {
                LRUObject[] tmp = {heap[parent], heap[left]};
                Arrays.sort(tmp);
                heap[parent] = tmp[0];
                heap[left] = tmp[1];
            }
            node = node - 2;
        }
    }

    private boolean isRightExist(int parent) {
        return (parent * 2 + 1) <= (heap.length - 1);
    }

    private void expandContainer() {
        LRUObject[] lruObjects = new LRUObject[heap.length + 1];
        System.arraycopy(heap, 0, lruObjects, 0, heap.length);
        heap = lruObjects;
    }
}
