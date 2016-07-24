package com.yachenya.list.arrayList;

import com.yachenya.list.List;
import java.util.Arrays;

class MyArrayList<E> implements List<E> {

    private static final int CAPACITY = 15;
    private E[] array;
    private int size;

    MyArrayList() {
        array = (E[]) new Object[CAPACITY];
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
    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    @Override
    public void add(E element) {
        add(size, element);
    }

    @Override
    public boolean remove(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(array[i])) {
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

    @Override
    public E get(int index) {
        validateIndex(index);
        return array[index];
    }

    @Override
    public E set(int index, E element) {
        validateIndexToAdd(index);

        E result = get(index);
        array[index] = element;
        return result;
    }

    private void increaseCapacity() {
        E[] newArray = (E[]) new Object[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    @Override
    public void add(int index, E element) {
        validateIndexToAdd(index);
        if (size >= array.length) {
            increaseCapacity();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    @Override
    public E remove(int index) {
        validateIndex(index);

        E result = array[index];
        if ((size - index - 1) > 0) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
        }
        array[--size] = null;
        return result;
    }


    @Override
    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E element) {
        for (int i = size - 1; i >= 0; i--) {
            if (element.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, size));
    }

    private void validateIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void validateIndexToAdd(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }
}



