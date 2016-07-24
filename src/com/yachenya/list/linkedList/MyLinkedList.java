package com.yachenya.list.linkedList;

import com.yachenya.list.List;

class MyLinkedList<E> implements List<E> {

    private Entry<E> first;
    private Entry<E> last;
    private int size;

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
        if (element != null) {
            add(size, element);
        }
    }

    @Override
    public boolean remove(E element) {
        if (element == null) {
            return false;
        }
        for (Entry<E> f = first; f != null; f = f.next) {
            if (f.element.equals(element)) {
                if (f.prev == null) {
                    f = first;
                    first.next = f.next;
                }
                if (f.next == null) {
                    f.prev = last;
                } else {
                    f.prev.next = f.next;
                    f.next = f.prev.next;
                }
            }
        }
        size--;
        return true;
    }

    @Override
    public void clear() {

        for (Entry<E> f = first; f != null;) {
            Entry<E> next = f.next;
            f.element = null;
            f.prev = null;
            f.next = null;
            f = next;
        }
        size = 0;
        first = last = null;
    }

    private Entry<E> entry(int index) {
        if (index < size >> 1) {
            Entry<E> f = first;
            for (int i = 0; i < index; i++) {
                f.next = f;
            }
            return f;
        } else {
            Entry<E> l = last;
            for (int i = size - 1; i > index; i--) {
                l = l.prev;
            }
            return l;
        }
    }

    @Override
    public E get(int index) {
        validateIndex(index);
        return entry(index).element;
    }

    @Override
    public E set(int index, E element) {
        validateIndex(index);
        Entry<E> entry = entry(index);
        E old = entry.element;
        entry.element = element;

        return old;
    }

    @Override
    public void add(int index, E element) {
        validateIndexToAdd(index);

        if (element != null) {
//add to the end of the list
            if (index == size) {
                Entry<E> l = last;
                Entry<E> newEntry = new Entry<>(l, element, null);
                last = newEntry;
                if (l == null) {
                    first = newEntry;
                } else {
                    l.next = newEntry;
                }
                size++;
                //add to the specified place
            } else {
                Entry<E> current = entry(index);
                Entry<E> previous = current.prev;
                Entry<E> newEntry = new Entry<>(previous, element, current);

                current.prev = newEntry;

                if (previous == null) {
                    first = newEntry;
                    newEntry.next = current;
                } else {
                    previous.next = newEntry;
                }
                size++;
            }
        }
    }

    @Override
    public E remove(int index) {
        validateIndex(index);

        for (Entry<E> f = first; f != null; f = f.next) {
            if (f.element.equals(entry(index).element)) {
                Entry<E> prev = f.prev;
                E current = f.element;
                Entry<E> next = f.next;

                if (prev == null) {
                    first = next;
                } else {
                    prev.next = next;
                    f.prev = null;
                }
                if (next == null) {
                    last = prev;
                } else {
                    next.prev = prev;
                    f.next = null;
                }
                size--;
                return current;
            }
        }
        return null;
    }

    @Override
    public int indexOf(E element) {
        int index = 0;

        for (Entry<E> f = first; f != null; f = f.next) {
            if (f.element.equals(element)) {
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
            if (l.element.equals(element)) {
                return index;
            }
        }
        return -1;
    }

    private static class Entry<E> {
        Entry<E> prev;
        E element;
        Entry<E> next;

        Entry(Entry<E> prev, E element, Entry<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }
    }
}
