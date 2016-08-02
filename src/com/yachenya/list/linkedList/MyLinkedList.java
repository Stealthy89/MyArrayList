package com.yachenya.list.linkedList;

import com.yachenya.list.List;

class MyLinkedList<E> implements List<E> {

    private Entry<E> first;
    private Entry<E> last;
    private int size;

    private static class Entry<E> {
        Entry<E> prev;
        E value;
        Entry<E> next;

        Entry(Entry<E> prev, E value, Entry<E> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
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
        for (Entry<E> f = first; f != null; f = f.next) {
            if (f.value.equals(element)) {
                Entry<E> previous = f.prev;
                Entry<E> next = f.next;

                if (previous == null && next == null) {
                    first = last = null;
                    size--;
                } else if (previous == null) {
                    first = next;
                    f.next = null;
                    next.prev = null;

                    size--;
                } else if (next == null) {
                    f.prev = null;
                    previous.next = null;
                    last = previous;

                    size--;
                } else {
                    previous.next = next;
                    next.prev = previous;
                    f.prev = null;
                    f.next = null;
                    size--;
                }
                return true;
            }
            return false;
        }

        return false;
    }

    @Override
    public void clear() {

        for (Entry<E> f = first; f != null; ) {
            Entry<E> next = f.next;
            f.value = null;
            f.prev = null;
            f.next = null;
            f = next;
        }
        size = 0;
        first = last = null;
    }

    private Entry<E> entry(int index) {
        validateIndexToAdd(index);

        if (index < size) {
            Entry<E> f = first;
            for (int i = 0; i < index; i++) {
                f = f.next;
            }
            return f;
        }
        return null;
    }

    @Override
    public E get(int index) {
        validateIndex(index);
        return entry(index).value;
    }

    @Override
    public E set(int index, E element) {
        validateIndexToAdd(index);

        Entry<E> entry = entry(index);
        E old = entry.value;
        entry.value = element;

        return old;
    }

    @Override
    public void add(int index, E value) {
        validateIndexToAdd(index);

        //assume element to be included at the start of the list
        if (index == 0) {
            Entry<E> f = first;
            Entry<E> newValue = new Entry<>(null, value, f);
            if (first == null) {
                first = last = newValue;
            } else {
                newValue.next = f;
                newValue.prev = null;
                f.prev = newValue;
                //  f.prev = newValue;
                first = newValue;
            }
            size++;
        }
        //assume element to be included at the end of the list
        else if (index == size) {
            Entry<E> l = last;
            Entry<E> newValue = new Entry<>(l, value, null);
            l.next = newValue;
            newValue.prev = l;
            newValue.next = null;
            last = newValue;
            size++;
        }
        //assume element to be included in the middle of the list
        else {
            Entry<E> current = entry(index);
            Entry<E> previous = current.prev;
            Entry<E> newValue = new Entry<>(previous, value, current);
            current.prev = newValue;
            previous.next = newValue;
            newValue.prev = previous;
            newValue.next = current;

            size++;
        }
    }


    @Override
    public E remove(int index){
        validateIndex(index);

        //first element to be deleted
        if (index == 0) {
            Entry<E> f = first;
            E result = f.value;
            Entry<E> next = first.next;
            first = next;
            f.next = null;
            next.prev = null;

            size--;
            return result;
        }
        //last element to be deleted
        else if (index == size) {
            Entry<E> l = last;
            E result = l.value;
            Entry<E> prev = last.prev;
            l.prev = null;
            prev.next = null;
            last = prev;
            size--;
            return result;
        }
        //element from the middle of the list to be deleted
        else {
            Entry<E> current = entry(index);
            E result = current.value;
            Entry<E> previous = current.prev;
            Entry<E> next = current.next;
            current.prev = null;
            current.next = null;
            previous.next = next;
            next.prev = previous;

            size--;
            return result;
        }
    }

    @Override
    public int indexOf(E element) {
        int index = 0;

        for (Entry<E> f = first; f != null; f = f.next) {
            if (f.value.equals(element)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E element) {
        int index = size;

        for (Entry<E> l = last; l != null; l = l.prev) {
            index--;
            if (l.value.equals(element)) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        for (Entry<E> f = first; f != null; f = f.next) {
            System.out.println(f.value);
        }
        return null;
    }

    private void validateIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index should be between 0 and " + size + " inclusively");
        }
    }

    private void validateIndexToAdd(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index should be between 0 and " + size);
        }
    }

}
