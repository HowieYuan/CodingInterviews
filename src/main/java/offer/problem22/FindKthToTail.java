package offer.problem22;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 22. 链表中倒数第k个结点
 * @Date 2019-01-22
 * @Time 22:29
 */
public class FindKthToTail {
    /**
     * 利用快慢指针，快指针先前进 k 位，然后两个指针同时走，当快指针走到尽头，慢指针即为解
     */
    public ListNode findKthToTail(ListNode head, int k) {
        if (k <= 0 || head == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        while (k-- != 1) {
            if (fast.next == null) {
                return null;
            }
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
