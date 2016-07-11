package com.yachenya.list;

import java.util.Arrays;

/**
 * My implementation of an array list
 *
 * @author ayachenya
 */

class MyArrayList implements List {

    private static final int CAPACITY = 15;
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

    @Override
    public boolean contains(Object o) {
        return indexOf(o) > 0;
    }

    @Override
    public void add(Object o) {
        add(size, o);
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(array[i])) {
                System.arraycopy(array, i + 1, array, i, size - i - 1);
                array[size--] = null;
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

    private void validateIndex(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Object get(int index) {
        validateIndex(index);
        return array[index];
    }

    @Override
    public Object set(int index, Object element) {
        Object result = get(index);
        array[index] = element;
        return result;
    }

    private void increaseCapacity() {
        Object[] newArray = new Object[CAPACITY * 2];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    @Override
    public void add(int index, Object element) {
        validateIndex(index);
        if (size >= CAPACITY) {
            increaseCapacity();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    @Override
    public Object remove(int index) {
        validateIndex(index);

        Object result = array[index];
        if ((size - index - 1) > 0) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
        }
        array[--size] = null;
        return result;
    }

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

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, size));
    }
}

