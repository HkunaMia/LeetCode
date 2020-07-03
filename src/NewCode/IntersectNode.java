package NewCode;

/**
 * @author ：mzr
 * @date ：Created in 2020/6/21 10:32
 * @description：两个单链表相交的一系列问题
 * @modified By：
 */

public class IntersectNode {

//    判读一个链表是否有环，如果有环，返回入环的第一个节点，无环返回null
    public Node getLoopNode(Node head){
        if(head == null || head.next == null || head.next.next == null){
            return null;
        }
//        一快一慢两个节点，当两个节点相遇时，则存在环
        Node fast = head.next.next;
        Node slow = head.next;
        while(fast != slow){
            if(fast.next.next == null || slow.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
//        固定slow节点，fast节点回到head，两者均已步长1进行遍历，相遇的节点为环的起始节点
        fast = head;
        while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

    }

    public Node noLoop(Node head1,Node head2){
//        n是用于计算两个链表的距离差
        int n = 0;
        Node p1 = head1;
        Node p2 = head2;
//      两个链表均遍历到末尾，如果末尾的节点不相等，则一定不相交。同时计算两个链表的长度差
        while(p1.next!=null){
            n++;
            p1 = p1.next;
        }
        while(p2.next!=null){
            n--;
            p2=p2.next;
        }

        if (p1!=p2){
            return null;
        }
//        p1是长一些的链表
        p1 = n>0 ? head1:head2;
        p2 = p1 == head1 ? head2: head1;
        n=Math.abs(n);
//        p1先走长度差的步数，然后两条链表长度相等，一起开始走，直到相遇
        while(n!=0){
            p1 = p1.next;
        }
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public Node bothLoop(Node head1,Node head2,Node loop1,Node loop2){
        Node cur1 = null;
        Node cur2 = null;
//        如果loop1 = loop2
        if(loop1 == loop2){
            int n = 0;
            Node p1 = head1;
            Node p2 = head2;
//      两个链表均遍历到末尾，如果末尾的节点不相等，则一定不相交。同时计算两个链表的长度差
            while(p1.next!=loop1){
                n++;
                p1 = p1.next;
            }
            while(p2.next!=loop2){
                n--;
                p2=p2.next;
            }

//        p1是长一些的链表
            p1 = n>0 ? head1:head2;
            p2 = p1 == head1 ? head2: head1;
            n=Math.abs(n);
//        p1先走长度差的步数，然后两条链表长度相等，一起开始走，直到相遇
            while(n!=0){
                p1 = p1.next;
            }
            while(p1 != p2){
                p1 = p1.next;
                p2 = p2.next;
            }
            return p1;
        }else{
//            入环不是同一个点，若相交，在一个环遍历一定能碰到另一个环
            cur1 = loop1.next;
            while(cur1 != loop1){
                if(cur1 == loop2){
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    public Node getInsterNode(Node head1,Node head2){
        if(head1==null || head2 == null){
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        //    2.两个无环的链表相交
        if(loop1 == null && loop2==null){
            return noLoop(head1,head2);
        }
        //    3.两个有环的链表相交
        if(loop1 !=null && loop2 != null){
            return bothLoop(head1,head2,loop1,loop2);
        }
        //    1.一个有环一个无环的链表，是不会相交的
        return null;
    }


}
