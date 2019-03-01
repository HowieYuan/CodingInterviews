package leetcode.linkedList.problem142;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 142.环形链表2(找到链表中环的入口结点)
 * @Date 2018-12-02
 * @Time 18:21
 */
public class LinkedListCycle2 {
    /**
     * Set
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode node = head;
        while(node != null) {
            if(!set.add(node)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    /**
     *  slow :  t = X + nY + k
     *  fast : 2t = X + mY + k
     *  ->   X + K = (m - 2n) Y
     */
    public ListNode detectCycle2(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                while(head != slow) {
                    slow = slow.next;
                    head = head.next;
                }
                return slow;
            }
        }
        return null;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
