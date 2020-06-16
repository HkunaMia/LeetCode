package VIVO;

import java.util.*;

/**
 * @author ：mzr
 * @date ：Created in 2020/6/7 15:32
 * @description：
 * @modified By：
 */


public class Three {

    public static void main(String[] args) {

        List<ListNode> lines = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for(int i = 0;i<n;i++){
            String[] ss = scanner.nextLine().split(" ");
            ListNode cur = new ListNode(0);
            ListNode p = cur;
            for (String s : ss) {
                cur.next = new ListNode(Integer.parseInt(s));
                cur = cur.next;
            }{

            }
            lines.add(p.next);
        }
        

        ListNode res  = new ListNode(-1);
        for (ListNode line : lines) {
            res = mergeNodes(res, line);
        }

        while (res.next != null){
            System.out.print(res.next.val + " ");
            res = res.next;
        }

    }

    static class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    private static ListNode mergeNodes(ListNode head1, ListNode head2) {
        ListNode newhead = new ListNode(0);
        ListNode p = newhead;
        while (head1 != null && head2 != null){
            if(head1.val <= head2.val){
                newhead.next = head1;
                head1 = head1.next;
            }else{
                newhead.next = head2;
                head2 = head2.next;
            }
            newhead = newhead.next;
        }
        newhead.next = head1 == null ? head2 : head1;
        return p.next;
    }


}