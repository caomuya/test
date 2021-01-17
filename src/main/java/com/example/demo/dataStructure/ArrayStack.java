package com.example.demo.dataStructure;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import java.util.Arrays;

/**
 * 栈 先入后出
 * @author caomuya
 */
public class ArrayStack {
    private String[] items;

    //栈中元素的个数
    private int count;
    //栈的大小
    private int n;

    public ArrayStack(String[] items, int count, int n) {
        this.items = items;
        this.count = count;
        this.n = n;
    }

    public ArrayStack(int n) {
        this.items = new String[n];
        this.count = 0;
        this.n = n;
    }


    public boolean push(String val){
        if(count == n){
            System.out.println("this stack is full");
            return false;
        }
        items[count]=val;
        count++;
        return true;
    }

    public String pop(){
        if(count==0){
            System.out.println("this stack is null");
            return null;
        }
        String val = items[count-1];
        items[count-1]=null;
        count--;
        return val;
    }

    public void clear(){
        this.items = new String[n];
        this.count = 0;
    }



    public static void main(String[] args) {

        ArrayStack stack = new ArrayStack(5);
        stack.push("one");
        stack.push("two");
        stack.push("one");
        stack.push("two");
        stack.push("213");
        stack.push("12314");
        System.out.println(stack.toString());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.push("three");
        stack.push("for");
        System.out.println(stack.toString());

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
