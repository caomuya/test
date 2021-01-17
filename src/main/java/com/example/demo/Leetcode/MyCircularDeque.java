package com.example.demo.Leetcode;

import com.example.demo.dataStructure.ListQueue;
import com.example.demo.dataStructure.SampleBrowser;
import lombok.val;

import java.util.Queue;

/**
 *
 * @author caomuya
 */
public class MyCircularDeque {

    private ListNode head;
    private int count;
    private int size;

    /**
     * ["MyCircularDeque","insertFront","getFront","isEmpty","deleteFront","insertLast","getRear","insertLast","insertFront",
     * "deleteLast","insertLast","isEmpty"]
     * [[8],[5],[],[],[],[3],[],[7],[7],[],[4],[]]
     * @param args
     *
     * [null,true,5,false,true,true,3,true,true,true,true,false]
     */

    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(8);
        System.out.println(circularDeque.insertFront(5));
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.isEmpty());
        System.out.println(circularDeque.deleteFront());
        System.out.println(circularDeque.insertLast(3));
        System.out.println(circularDeque.getRear());
        System.out.println(circularDeque.insertLast(7));
        System.out.println(circularDeque.insertFront(7));
        System.out.println(circularDeque.deleteLast());
        System.out.println(circularDeque.insertLast(4));
        System.out.println(circularDeque.isEmpty());


    }

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.size=k;
        this.count=0;
        this.head=null;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        ListNode node = new ListNode(value);
        if(head == null){
            head=node;
            this.count++;
            return true;
        }
        if(count == size){
            return false;
        }
        node.next=head;
        head = node;
        this.count++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        ListNode node = new ListNode(value);
        if(head == null){
            head=node;
            this.count++;
            return true;
        }
        if(count == size){
            return false;
        }
        ListNode p = head;
        while (p.next!=null){
            p=p.next;
        }
        p.next=node;
        this.count++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(count == 0){
            return false;
        }
        head = head.next;
        count--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(count == 0){
            return false;
        }
        if(count == 1){
            head = null;
            count--;
            return true;
        }
        ListNode p = head;
        while (p.next!=null && p.next.next!=null){
            p=p.next;
        }
        p.next =null;
        count--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(count == 0){
            return -1;
        }
        int val = head.val;
//        head = head.next;
//        count--;
        return val;

    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(count == 0){
            return -1;
        }
        if(count == 1){
            int val = head.val;
//            head = null;
//            count--;
            return val;
        }
        ListNode p = head;
        while (p.next!=null && p.next.next!=null){
            p=p.next;
        }
        int val = p.next.val;
//        p.next =null;
//        count--;
        return val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if(count==0){
            return true;
        }
        return false;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return count == size;
    }

    public static class ListNode{
        private int val;

        private ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }
}
