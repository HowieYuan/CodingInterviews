package leetcode.linkedList;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 206.反转链表
 * @Date 2018-11-19
 * @Time 15:29
 */
public class Reverse {
    public ListNode reverseList(ListNode head) {
        ListNode current = null, next;
        while (head != null) {
            next = head.next;
            head.next = current;
            current = head;
            head = next;
        }
        return current;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
