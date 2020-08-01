package Leetcode;

/**
 * @author ：mzr
 * @date ：Created in 2020/5/10 11:07
 * @description：链表两数相加
 * @modified By：
 */

public class top2 {
     public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x; }
     }

     public ListNode addTwoSum(ListNode l1, ListNode l2){
         ListNode head = new ListNode(0);
         ListNode h = head;
         ListNode p1 = l1;
         ListNode p2 = l2;
         int carry = 0;
         while (p1 != null || p2 != null) {
             int x = (p1 != null) ? p1.val : 0;
             int y = (p2 != null) ? p2.val : 0;
             int sum = carry + x + y;
             carry = sum / 10;
             h.next = new ListNode(sum % 10);
             h = h.next;
             if (p1 != null) p1 = p1.next;
             if (p2 != null) p2 = p2.next;
         }
         if (carry > 0) {
             h.next = new ListNode(carry);
         }
         return head.next;


     }
}
