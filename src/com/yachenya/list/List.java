package com.yachenya.list;

/**
 * List Interface
 * @author ayachenya
 */
interface List {

    int size();
    boolean isEmpty();
    boolean contains(Object o);
    boolean add(Object o);
    boolean remove(Object o);
    void clear();
    Object get(int index);
    Object set(int index, Object element);
    void add(int index, Object element);
    Object remove(int index);
    int indexOf(Object o);
    int lastIndexOf(Object o);
}
