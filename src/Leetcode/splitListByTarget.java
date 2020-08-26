package Leetcode;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2020/8/4
 * \* Time: 12:15
 * \* To change this template use File | Settings | File Templates.
 * \* Description:编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。
 * 如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
 * \
 */

public class splitListByTarget {

    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
        }
    }


    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next==null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode lpre = null;
        ListNode low = head;
        while(low!=null){
            if(low.val<x){
                lpre.next = low.next;
                low.next = dummy.next;
                dummy.next = low;
                low = lpre.next;
            }else{
                lpre = lpre.next;
                low = low.next;
            }
        }
        return dummy.next;
    }
}
