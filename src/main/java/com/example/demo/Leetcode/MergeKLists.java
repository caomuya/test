package com.example.demo.Leetcode;

import java.util.PriorityQueue;

/**
 * @author caomuya
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((o1, o2) -> Integer.compare(o1.val,o2.val));
        for(ListNode node:lists){
            if(node!=null){
                pq.add(node);
            }
        }

        while(!pq.isEmpty()){
            ListNode poll = pq.poll();
            head.next=poll;
            head=head.next;
            if(poll.next!=null){
                pq.add(poll.next);
            }

        }
        return dummy.next;
    }


    public static void main(String[] args) {
        MergeKLists mergeKLists = new MergeKLists();
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(6);
        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(2);
        lists[1].next.next = new ListNode(3);
        lists[2] = new ListNode(5);
        lists[2].next = new ListNode(8);
        ListNode node = mergeKLists.mergeKLists(lists);
        System.out.println(node.toString());

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
