package leetcode.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 141.环形链表
 * @Date 2018-12-02
 * @Time 17:52
 */
public class LinkedListCycle {
    /**
     * 常规方法，利用Set
     */
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode node = head;
        while(node != null) {
            if(!set.add(node)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    /**
     * 快慢指针方法
     */
    public boolean hasCycle2(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
