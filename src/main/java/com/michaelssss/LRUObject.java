package com.michaelssss;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Micha on 2017/4/20.
 */
public class LRUObject implements Comparable<LRUObject> {
    public LRUObject(Object o) {
        this.lastUserTime = System.nanoTime();
        this.o = o;
        this.requestTime = new AtomicLong(0L);
    }

    private AtomicLong requestTime;
    private long lastUserTime;
    private Object o;

    public AtomicLong getRequestTime() {
        return requestTime;
    }

    public Object getO() {
        requestTime.incrementAndGet();
        return o;
    }

    @Override
    public boolean equals(Object o1) {
        return this.o.equals(o1);
    }

    @Override
    public int hashCode() {
        return o != null ? o.hashCode() : 0;
    }

    @Override
    public int compareTo(LRUObject o) {
        return (int) -(o.getRequestTime().get() - requestTime.get());
    }

    @Override
    public String toString() {
        return "LRUObject{" +
                "requestTime=" + requestTime.get() +
                ", lastUserTime=" + lastUserTime +
                ", o=" + o +
                '}';
    }
}
