package com.yachenya.list;

import org.junit.Assert;
import org.junit.Test;

public class MyArrayListTests{

    private MyArrayList arrayList = new MyArrayList();

    @Test
    public void testSize() throws Exception {
        arrayList.add(1);
        Assert.assertEquals(1, arrayList.size());
        arrayList.add(0, 12);
        Assert.assertEquals(2, arrayList.size());
        arrayList.remove(0);
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void testIsEmpty() throws Exception {
        Assert.assertTrue(arrayList.isEmpty());
        arrayList.add(1);
        Assert.assertFalse(arrayList.isEmpty());
    }

    @Test
    public void testContains() throws Exception {
        arrayList.add(1);
        arrayList.add("Srt");
        arrayList.add('&');
        Assert.assertEquals(true, arrayList.contains("Srt"));
        Assert.assertEquals(false, arrayList.contains(10));
    }

    @Test
    public void testRemove() throws Exception {
        arrayList.add("S");
        arrayList.add("M");
        arrayList.add("N");
        arrayList.add("O");
        Assert.assertEquals(true, arrayList.remove("S"));
        Assert.assertEquals(false, arrayList.remove("A"));
    }

    @Test
    public void testClear() throws Exception {
        arrayList.add(1);
        arrayList.clear();
        Assert.assertEquals(0, arrayList.size());
    }

    @Test
    public void testGet() throws Exception {
        arrayList.add(1);
        Assert.assertEquals(1, arrayList.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetNegative() throws Exception {
        arrayList.get(1);
        arrayList.get(-1);
    }

    @Test
    public void testSet() throws Exception {
        arrayList.add(2);
        arrayList.add(1);
        arrayList.add("A");

        Assert.assertEquals("A", arrayList.set(2, "B"));
        Assert.assertEquals(2, arrayList.set(0, 3));
    }

    @Test
    public void testAddVoid() throws Exception {
        arrayList.add(10);
        arrayList.add(12);
        arrayList.add(0, 1);
        Assert.assertEquals(1, arrayList.get(0));
        Assert.assertEquals(10, arrayList.get(1));
        Assert.assertEquals(12, arrayList.get(2));
    }

    @Test
    public void testRemoveByIndex() throws Exception {
        arrayList.add(1);
        arrayList.add(12);
        Assert.assertEquals(1, arrayList.remove(0));
        Assert.assertEquals(12, arrayList.get(0));
    }

    @Test
    public void testIndexOf() throws Exception {
        arrayList.add(1);
        arrayList.add(12);
        arrayList.add(1);
        Assert.assertEquals(0, arrayList.indexOf(1));
    }

    @Test
    public void testLastIndexOf() throws Exception {
        arrayList.add(1);
        arrayList.add(12);
        arrayList.add(1);
        Assert.assertEquals(2, arrayList.lastIndexOf(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testValidateIndexNegative() throws Exception {
     arrayList.add(-1, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testValidateIndexHuge() throws Exception {
        arrayList.add(0,1);
        arrayList.add(1,2);
        arrayList.add(4, 3);
    }
    @Test
    public void testIncreaseCapacity() throws Exception {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        arrayList.add(9);
        arrayList.add(10);
        arrayList.add(11);
        arrayList.add(12);
        arrayList.add(13);
        arrayList.add(14);
        arrayList.add(15);
        Assert.assertEquals(15, arrayList.size());
        arrayList.add(16);
        Assert.assertEquals(16, arrayList.size());
    }
}
