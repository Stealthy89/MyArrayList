package com.yachenya.list.linkedList;

import org.junit.Assert;
import org.junit.Test;

public class MyLinkedListTests {

    private MyLinkedList<Integer> linkedList = new MyLinkedList<>();

    @Test
    public void testSize(){
        Assert.assertEquals(0,linkedList.size());
        linkedList.add(0,2);
        Assert.assertEquals(1,linkedList.size());
        linkedList.add(1,4);
        Assert.assertEquals(2,linkedList.size());
    }

    @Test
    public void testIsEmpty() {
        Assert.assertTrue(linkedList.isEmpty());
        linkedList.add(0,2);
        Assert.assertFalse(linkedList.isEmpty());
    }

    @Test
    public void testAdd(){
        linkedList.add(0,1);
        Assert.assertEquals(new Integer("1"), linkedList.get(0));
        linkedList.add(1,30);
        Assert.assertEquals(new Integer("30"), linkedList.get(1));
        linkedList.add(0,2);
        Assert.assertEquals(new Integer("2"), linkedList.get(0));
        Assert.assertEquals(new Integer("1"), linkedList.get(1));
        Assert.assertEquals(new Integer("30"), linkedList.get(2));
    }

    @Test
    public void testSet(){
        linkedList.add(0,1);
        linkedList.add(1,2);
        linkedList.set(0,10);
        Assert.assertEquals(new Integer("10"), linkedList.get(0));
        Assert.assertEquals(new Integer("2"), linkedList.get(1));
    }
   @Test
    public void testRemove(){
       linkedList.add(0,10);
       linkedList.add(1,20);
       linkedList.add(2,30);
       Assert.assertEquals(3, linkedList.size());
       Assert.assertTrue(linkedList.remove(new Integer("20")));
       Assert.assertEquals(2, linkedList.size());
       Assert.assertEquals(new Integer("30"),linkedList.get(1));
   }
    @Test
    public void testRemoveByIndex(){
        linkedList.add(0,10);
        linkedList.add(1,20);
        linkedList.add(2,30);
        Assert.assertEquals(3, linkedList.size());
        Assert.assertEquals(new Integer("20"), linkedList.remove(1));
        Assert.assertEquals(2, linkedList.size());
        Assert.assertEquals(new Integer("30"), linkedList.get(1));

    }

    @Test
    public void testIndexOf(){
        linkedList.add(0,10);
        linkedList.add(1,20);
        linkedList.add(2,10);

        Assert.assertEquals(0, linkedList.indexOf(new Integer("10")));
    }

    @Test
    public void testContains(){
        linkedList.add(0,10);
        linkedList.add(1,20);
        linkedList.add(2,10);

        Assert.assertTrue(linkedList.contains(new Integer("20")));
        Assert.assertFalse(linkedList.contains(new Integer("0")));

    }
    @Test
    public void testLastIndexOf(){
        linkedList.add(0,10);
        linkedList.add(1,20);
        linkedList.add(2,10);

        Assert.assertEquals(2, linkedList.lastIndexOf(new Integer("10")));
    }

    @Test
    public void testClear(){
        linkedList.add(0,10);
        linkedList.add(1,20);
        linkedList.add(2,10);
        Assert.assertEquals(3, linkedList.size());

        linkedList.clear();
        Assert.assertEquals(0, linkedList.size());
    }

}
