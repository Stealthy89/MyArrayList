package com.yachenya.list;

/**
 * My implementation of an array list
 *
 * @author ayachenya
 */
public class MyArrayList implements List {

    private static final int CAPACITY = 15;
    private Object[] myList;
    private int size;

    public MyArrayList() {
        this.myList = new Object[CAPACITY];
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (myList[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    public boolean add(Object o) {
        myList[size++] = o;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (myList[i].equals(o)) {
                myList[i] = myList[i + 1];
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            myList[i] = null;
        }
        size = 0;
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {
        return myList[index];
    }

    @Override
    public Object set(int index, Object element) throws IndexOutOfBoundsException {
        Object result = get(index);
        myList[index] = element;
        return result;
    }

    @Override
    public void add(int index, Object element) {
        for (int i = 0; i < size; i++) {
            if (i == index) {
                System.arraycopy(myList, index, myList, index + 1, size - index);
                myList[i] = element;
                size++;
            }
        }
    }

    @Override
    public Object remove(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i < size; i++) {
            if (i == index) {
                Object result = myList[i];
                myList[i] = myList[i + 1];
                return result;
            }
        }
        return null;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size(); i++) {
            if (myList[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size() - 1; i >= 0; i--) {
            if (myList[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }
}

