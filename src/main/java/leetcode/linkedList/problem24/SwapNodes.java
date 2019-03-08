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
        ListNode result = head.next;
        ListNode preNode = new ListNode(0);;
        while (head != null && head.next != null) {
            ListNode next = head.next;
            preNode.next = next;
            head.next = head.next.next;
            next.next = head;
            preNode = head;
            head = head.next;
        }
        return result;
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
