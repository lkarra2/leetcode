package main.java.amazon;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode prev = head;
        int sum = 0, carry = 0, first = 0, second = 0;
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        while(l1 != null || l2 != null || carry != 0) {
            first = (l1 == null) ? 0 : l1.val;
            second = (l2 == null) ? 0 : l2.val;
            sum = first + second + carry;
            ListNode tmp = new ListNode(sum%10);
            prev.next = tmp;
            prev = tmp;
            carry = sum/10;
            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }

        return head.next;
    }
}