package offer.problem24;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 24.反转链表
 * @Date 2019-01-23
 * @Time 0:50
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode current = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = current;
            current = head;
            head = next;
        }
        return current;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
