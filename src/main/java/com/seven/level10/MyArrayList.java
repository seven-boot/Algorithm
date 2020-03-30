package com.seven.level10;

import java.util.Vector;

/**
 * @author QH
 * @date 2019/11/21
 * @description 手写 ArrayList
 */
public class MyArrayList {

    private Object[] elementData;

    private int size;

    public MyArrayList() {
        this(10);
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException();
        }
        elementData = new Object[initialCapacity];
    }

    public void add(Object obj) {
        ensureCapacity();
        elementData[size++] = obj;
    }

    public void add(int index, Object obj) {
        rangeCheck(index);
        ensureCapacity();
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = obj;
        size++;
    }

    public Object get(int index) {
        rangeCheck(index);
        return elementData[index];
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
    }

    public void remove(int index) {
        rangeCheck(index);
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = numMoved;
    }

    public void remove(Object obj) {
        for (int i = 0; i < size; i++) {
            if (get(i).equals(obj)) {
                remove(i);
            }
        }
    }

    public Object set(int index, Object obj) {
        rangeCheck(index);

        Object oldValue = elementData[index];
        elementData[index] = obj;
        return oldValue;
    }

    /**
     * 数组扩容
     */
    private void ensureCapacity() {
        // 数组扩容
        if (size == elementData.length) {
            Object[] newArray = new Object[size*2 + 1];
            System.arraycopy(elementData, 0, newArray, 0, elementData.length);
            elementData = newArray;
        }
    }

    public static void main(String[] args) {
        MyArrayList list = new MyArrayList(3);
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        System.out.println(list.size);

    }
}
