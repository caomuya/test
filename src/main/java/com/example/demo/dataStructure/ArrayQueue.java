package com.example.demo.dataStructure;

import java.util.Arrays;

/**
 * 队列 先入先出
 * @author caomuya
 */
public class ArrayQueue {
    private String[] items;

    //队列中元素的个数
    private int count;
    //队列的大小
    private int n;

    public ArrayQueue(String[] items, int count, int n) {
        this.items = items;
        this.count = count;
        this.n = n;
    }

    public ArrayQueue(int n) {
        this.items = new String[n];
        this.count = 0;
        this.n = n;
    }


    public boolean push(String val){
        if(count == n){
            System.out.println("this queue is full");
            return false;
        }
        items[count]=val;
        count++;
        return true;
    }

    public String pop(){
        if(count==0){
            System.out.println("this queue is null");
            return null;
        }
        String val = items[0];
        for(int i=0;i< count-1;++i){
            items[i]=items[i+1];
        }

        items[count-1]=null;
        count--;
        return val;
    }



    public static void main(String[] args) {

        ArrayQueue queue = new ArrayQueue(5);
        queue.push("one");
        queue.push("two");
        queue.push("one");
        queue.push("two");
        queue.push("213");
        queue.push("12314");
        System.out.println(queue.toString());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());

        queue.push("three");
        queue.push("for");
        System.out.println(queue.toString());

    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "items=" + Arrays.toString(items) +
                ", count=" + count +
                ", n=" + n +
                '}';
    }
}
