package com.nhnacademy;

public interface SimpleListIterator {
    boolean hasNext();
    int next();
    boolean hasPrevious();
    int previous();
    void remove();
}
