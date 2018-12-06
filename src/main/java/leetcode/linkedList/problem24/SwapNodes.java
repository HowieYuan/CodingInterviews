package leetcode.linkedList.problem24;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 24. 两两交换链表中的节点
 * @Date 2018-11-28
 * @Time 19:32
 */
public class SwapNodes {
    /**
     * 迭代
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head, pre = new ListNode(0);
        head = head.next;
        while (node != null && node.next != null) {
            ListNode a = node.next;
            ListNode b = a.next;
            pre.next = a;
            pre = node;
            a.next = node;
            node.next = b;
            node = b;
        }
        return head;
    }

    /**
     * 递归
     */
    public static ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = head.next;
        head.next = swapPairs(head.next.next);
        result.next = head;

        return result;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
