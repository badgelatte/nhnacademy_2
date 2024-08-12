package com.nhnacademy.exam3_7_1;

import java.util.Arrays;

import com.nhnacademy.SimpleList;
import com.nhnacademy.SimpleListIterator;

public class SimpleArrayList implements SimpleList{
    class Iterator implements SimpleListIterator {
        int current = -1;

        @Override
        public boolean hasNext() {
            return (current+1) < count;
        }

        @Override
        public boolean hasPrevious() {
            return 0 <= current;
        }

        @Override
        public int next() {
            int data = datas[current+1];
            current++;
            return data;
        }

        @Override
        public int previous() {
            int data = datas[current];
            current--;
            return data;
        }

        @Override
        public void remove() {
            removeAt(current+1);
        }

    }
    int[] datas;
    int DEFAULT = 10;
    int count = 0;

    public SimpleArrayList(){
        datas = new int[DEFAULT];
    }

    public SimpleArrayList(int capacity) {
        datas = new int[capacity];
    }

    @Override
    public boolean isEmpty() {
        return count <= 0;
    }

    @Override
    public void add(int data) {
        if(count >= datas.length) {
            int[] newDatas = Arrays.copyOf(datas, datas.length + DEFAULT);
            datas = newDatas;
        }
        datas[count++] = data;
    }

    @Override
    public int remove() {
        int data = datas[0];
        count--;
        System.arraycopy(datas, 1, datas, 0, datas.length - 1);
        return data;
    }

    public int removeAt(int index) {
        if(index >= count) {
            throw new IndexOutOfBoundsException();
        }
        int data = datas[index];
        System.arraycopy(datas, index + 1, datas, index, count - index -1);
        --count;
        return data;
    }

    @Override
    public boolean remove(int data) {
        for (int i = 0; i < count; i++) {
            if(datas[i] == data) {
                count--;
                System.arraycopy(datas, i, datas, i-1, datas.length -i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(int data) {
        for (int i = 0; i < count; i++) {
            if(datas[i] == data) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public String toString() {
        if(count <= 0) {
            return "[]";
        }
        String result = "[" + datas[0];
        for (int i = 1; i < count; i++) {
            result += (", " + datas[i]);
        }
        result += "]";
        return result;
    }
    
    @Override
    public SimpleListIterator iterator() {
        return new Iterator();
    }

    public static void main(String[] args) {
        SimpleList list = new SimpleArrayList();

        System.out.println(list);
        list.add(1);
        System.out.println(list);
        list.add(2);
        System.out.println(list);
        list.add(3);
        System.out.println(list);
        list.add(4);
        System.out.println(list);
        System.out.println("list.size(): " + list.size());
        System.out.println("list.contains(2): " + list.contains(2));
        System.out.println("list.contains(3): " + list.contains(3));
        System.out.println("list.remove(): " + list.remove());
        System.out.println("list: " + list);

    }

    
}
