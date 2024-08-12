package com.nhnacademy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.nhnacademy.exam3_7_1.SimpleArrayList;

public class TestExam3_7_1 {
    SimpleList list;
    SimpleListIterator iterator;

    @Before
    public void setUp(){
        list = new SimpleArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        iterator = list.iterator();

    }

    @Test
    public void addTest(){
        list.add(4);
        Assert.assertEquals(4, list.size());
    }

    @Test
    public void isEmpty(){
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void remove(){
        Assert.assertEquals(1, list.remove());
    }

    @Test
    public void removeData(){
        Assert.assertTrue(list.remove(2));
    }

    @Test
    public void contains(){
        Assert.assertTrue(list.contains(2));
    }

    @Test
    public void size(){
        Assert.assertEquals(3, list.size());
    }

    @Test
    public void hasNext(){
        Assert.assertTrue(iterator.hasNext());
    }

    @Test
    public void next() {
        Assert.assertEquals(1, iterator.next());
    }

    @Test
    public void hasPrevious(){
        iterator.next();
        Assert.assertTrue(iterator.hasPrevious());
    }

    @Test
    public void previous(){
        iterator.next();
        Assert.assertEquals(1, iterator.previous());
    }

    @Test
    public void removeIterator(){
        iterator.remove();
        Assert.assertEquals(2, iterator.next());
    }
}
