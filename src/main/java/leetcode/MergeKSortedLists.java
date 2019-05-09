package main.java.leetcode;


import java.util.Comparator;
import java.util.PriorityQueue;

// Definition for singly-linked list.
class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
}

class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0)
            return null;

        ListNode head = new ListNode(0);
        ListNode tail = head;

        // Priority Queue with comparator to order based on val
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                if(l1.val < l2.val)
                    return -1;
                else if(l1.val == l2.val)
                    return 0;
                else
                    return 1;
            }
        });

        // Adding first k nodes to queue
        for(ListNode l: lists) {
            if(l != null) {
                q.add(l);
            }
        }

        // Constructing the linkedlist by polling from the Priority Queue
        while(!q.isEmpty()) {
            tail.next = q.poll();
            tail = tail.next;

            if(tail.next != null) {
                q.add(tail.next);
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(8);

        ListNode[] list = { l1, l2};
        MergeKSortedLists m = new MergeKSortedLists();
        ListNode head = m.mergeKLists(list);

        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
