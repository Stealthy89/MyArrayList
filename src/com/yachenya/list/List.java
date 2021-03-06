package com.yachenya.list;

public interface List<E> {

    int size();

    boolean isEmpty();

    boolean contains(E element);

    void add(E element);

    boolean remove(E element);

    void clear();

    E get(int index);

    E set(int index, E element);

    void add(int index, E element);

    E remove(int index);

    int indexOf(E element);

    int lastIndexOf(E element);
}