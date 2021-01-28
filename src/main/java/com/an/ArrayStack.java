package com.an;


/**
 * 栈
 */
public class ArrayStack {
    //数组
    private final String[] items;
    //容量大小
    private final int size;
    //元素个数
    private int count;

    public ArrayStack(int size) {
        this.size = size;
        this.count = 0;
        this.items = new String[size];
    }

    //入栈
    //O(1)
    public boolean push(String item) {
        //判断容量
        if (count == size) {
            return false;
        }
        this.items[count] = item;
        ++count;
        return true;
    }

    //出栈
    //O(1)
    public String pop() {
        if (size == 0) {
            return null;
        }
        String temp = items[count - 1];
        --count;
        return temp;
    }
}
