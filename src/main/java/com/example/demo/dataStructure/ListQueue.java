package com.example.demo.dataStructure;



/**
 * 队列 先入先出
 * @author caomuya
 */
public class ListQueue {

    private ListNode head;


    public boolean push(int val ){
        ListNode listNode = new ListNode(val);
        if (head == null){
            head=listNode;
            return true;
        }
        ListNode p = head;
        while(p.next !=null ){
            p = p.next;
        }
        p.next=listNode;
        return true;
    }


    public int pop(){
        if(head == null){
            return -1;
        }
        ListNode p = head;

        head = head.next;
        return p.val;
    }


    public static void main(String[] args) {
        ListQueue stack = new ListQueue();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        stack.push(3);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
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


        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
