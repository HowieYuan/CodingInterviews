package offer.problem18;


/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description P119 18.删除链表的节点
 * @Date 2018-12-02
 * @Time 14:18
 */
public class DeleteNode {
    public static ListNode deleteNode(ListNode head, ListNode deletedNode) {
        if (head == deletedNode && head.next == null) {
            return null;
        }
        if (head != null && deletedNode != null) {
            if (deletedNode.next == null) {
                ListNode node = head;
                while (node.next != deletedNode) {
                    node = node.next;
                }
                node.next = null;
            } else {
                deletedNode.val = deletedNode.next.val;
                deletedNode.next = deletedNode.next.next;
            }
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
