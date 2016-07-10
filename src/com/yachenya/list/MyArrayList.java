package com.yachenya.list;

import java.util.Arrays;

/**
 * My implementation of an array list
 *
 * @author ayachenya
 */

//1. Change github view;
// 2. myarraylist - rework methods and tests. look through the commets.
class MyArrayList implements List {

    private static final int CAPACITY = 15;
    //array  +
    private Object[] array;
    private int size;

    MyArrayList() {
        array = new Object[CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //indexOf() +
    @Override
    public boolean contains(Object o) {
        return indexOf(o) > 0;
    }

    //add( , )  +

    @Override
    public void add(Object o) {
        add(size, o);
    }

    // 2, 3, 5, 6 - remove 3 -> 2, 5, 5, 6
    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(array[i])) {
                System.arraycopy(array, i + 1, array, i, size - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    private int validateIndex(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        } else {
            return index;
        }
    }

    @Override
    public Object get(int index) {
        return array[validateIndex(index)];
    }

    @Override
    public Object set(int index, Object element) {
        Object result = get(index);
        array[index] = element;
        return result;
    }

    /*if array is full -> newarray=array*2*/
    //without for
    //2, 3, 4 - add(5, 1) -> exception (size = 3) max index = 3 - 2, 3, 4, 1
    @Override
    public void add(int index, Object element) {
        try {
            validateIndex(index);
            System.arraycopy(array, index, array, index + 1, size + 1);
            array[index] = element;
            size++;
        } catch (IndexOutOfBoundsException e) {
            Object[] newArray = new Object[CAPACITY * 2];
            System.arraycopy(array, 0, newArray, 0, size);
            newArray[index] = element;
            size++;
        }
    }

    //wrong
    @Override
    public Object remove(int index) {
        validateIndex(index);
        Object result = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return result;
    }

    // str.equals("Hello")  -  "Hello".equals(str) +
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size() - 1; i >= 0; i--) {
            if (o.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    //toString() +
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, size));
    }
}

