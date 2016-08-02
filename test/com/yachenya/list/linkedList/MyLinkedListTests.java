package com.yachenya.list.linkedList;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class MyLinkedListTests {

    private MyLinkedList<Integer> linkedList = new MyLinkedList<>();
    private MyLinkedList<String> linkedList2 = new MyLinkedList<>();

    @Test
    public void testSize() {
        Assert.assertEquals(0, linkedList.size());
        linkedList.add(0, 2);
        Assert.assertEquals(1, linkedList.size());
        linkedList.add(1, 4);
        Assert.assertEquals(2, linkedList.size());
    }

    @Test
    public void testIsEmpty() {
        Assert.assertTrue(linkedList.isEmpty());
        linkedList.add(0, 2);
        Assert.assertFalse(linkedList.isEmpty());
    }

    @Test
    public void testAddVoid() throws Exception {
        linkedList.add(10);
        linkedList.add(12);
        linkedList.add(0, 1);
        Assert.assertThat(1, is(linkedList.get(0)));
        Assert.assertThat(10, is(linkedList.get(1)));
        Assert.assertThat(12, is(linkedList.get(2)));
    }

    @Test
    public void testAdd() {
        linkedList.add(0, 1);
        Assert.assertThat(1, is(linkedList.get(0)));
        linkedList.add(1, 30);
        Assert.assertThat(30, is(linkedList.get(1)));
        linkedList.add(0, 2);
        Assert.assertThat(2, is(linkedList.get(0)));
        Assert.assertThat(1, is(linkedList.get(1)));
        Assert.assertThat(30, is(linkedList.get(2)));
    }

    @Test
    public void testGet() throws Exception {
        linkedList.add(1);
        Assert.assertThat(1, is(linkedList.get(0)));
    }

    @Test
    public void testSet() {
        linkedList.add(0, 1);
        linkedList.add(1, 2);
        linkedList.set(0, 10);
        Assert.assertThat(10, is(linkedList.get(0)));
        Assert.assertThat(2, is(linkedList.get(1)));
    }

    @Test
    public void testRemove() {
        linkedList2.add("S");
        linkedList2.add("M");
        linkedList2.add("L");
        Assert.assertEquals(3, linkedList2.size());
        Assert.assertEquals(true, linkedList2.remove("S"));
        Assert.assertEquals(2, linkedList2.size());
        Assert.assertThat("L", is(linkedList2.get(1)));
        Assert.assertEquals(false, linkedList2.remove("A"));

//       linkedList.add(0,10);
//       linkedList.add(1,20);
//       linkedList.add(2,30);
//       int value = 20;
//       Assert.assertEquals(3, linkedList.size());
//       Assert.assertThat(true, is(linkedList.remove(value)));
//       Assert.assertEquals(2, linkedList.size());
//       Assert.assertThat(30,is(linkedList.get(1)));
    }

    @Test
    public void testRemoveByIndex() {
        linkedList.add(0, 10);
        linkedList.add(1, 20);
        linkedList.add(2, 30);
        Assert.assertEquals(3, linkedList.size());
        Assert.assertThat(20, is(linkedList.remove(1)));
        Assert.assertEquals(2, linkedList.size());
        Assert.assertThat(30, is(linkedList.get(1)));
    }

    @Test
    public void testIndexOf() {
        linkedList.add(0, 10);
        linkedList.add(1, 20);
        linkedList.add(2, 10);

        Assert.assertThat(0, is(linkedList.indexOf(10)));
    }

    @Test
    public void testContains() {
        linkedList.add(0, 10);
        linkedList.add(1, 20);
        linkedList.add(2, 10);

        Assert.assertThat(true, is(linkedList.contains(20)));
        Assert.assertThat(false, is(linkedList.contains(0)));
    }

    @Test
    public void testLastIndexOf() {
        linkedList.add(0, 10);
        linkedList.add(1, 20);
        linkedList.add(2, 10);

        Assert.assertThat(2, is(linkedList.lastIndexOf(10)));
    }

    @Test
    public void testClear() {
        linkedList.add(0, 10);
        linkedList.add(1, 20);
        linkedList.add(2, 10);
        Assert.assertEquals(3, linkedList.size());

        linkedList.clear();
        Assert.assertEquals(0, linkedList.size());
    }

    @Test
    public void testToString() throws Exception {
        linkedList.add(0, 1);
        linkedList.add(1, 2);
        linkedList.toString();
    }
}
