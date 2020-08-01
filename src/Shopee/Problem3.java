package Shopee;

import java.util.Scanner;

/**
 * @author ：mzr
 * @date ：Created in 2020/7/28 22:08
 * @description：
 * @modified By：
 */

public class Problem3 {

    public class ListNode1 {
        int val;
        ListNode1 next = null;

        public ListNode1(int data){
            this.val = data;
        }
    }

    public ListNode1 reverseLinkedList (ListNode1 head, int n) {
        // write code here
        ListNode1 dummy = new ListNode1(0);
        dummy.next = head;
        ListNode1 pre = dummy;
        ListNode1 end = dummy;

        while(end.next!=null){
            for(int i =0 ;i<n && end !=null;i++){
                end = end.next;
            }
            if(end == null) break;
            ListNode1 start = pre.next;
            ListNode1 next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end=pre;
        }
        return dummy.next;
    }

    public ListNode1 reverse(ListNode1 head){
        ListNode1 pre = null;
        ListNode1 curr = head;
        while(curr != null){
            ListNode1 next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public ListNode1 stringToList(String[] input){
        int[] output = new int[input.length];
        for (int index = 0; index < input.length; index++) {
            String part = input[index].trim();
            output[index] = Integer.parseInt(part);
        }
        ListNode1 head = new ListNode1(output[0]);
        ListNode1 p = head;
        for(int i = 1;i<output.length;i++){
            head.next = new ListNode1(output[i]);
            head = head.next;
        }
        return p;
    }

    public String listToString(ListNode1 head){
        String result = "";

        while (head!=null){
            result += Integer.toString(head.val)+",";
            head = head.next;
        }

        return "{" + result.substring(0,result.length()-1) + "}";
    }



    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        String input = in.nextLine();
        input = input.trim();
        String[] parts = input.split("},");
        String list = parts[0];
        int n = Integer.parseInt(parts[1]);
        input = list.substring(1, list.length());
        String[] inputString = input.split(",");
        Problem3 problem3 = new Problem3();
        ListNode1 head = problem3.stringToList(inputString);
        ListNode1 listNode = problem3.reverseLinkedList(head, n);
        String result = problem3.listToString(listNode);
        System.out.println(result);
    }
}
