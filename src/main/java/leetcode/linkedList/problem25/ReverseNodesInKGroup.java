package leetcode.linkedList.problem25;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 25. Reverse Nodes in k-Group
 * @Date 2018-12-06
 * @Time 16:44
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2 || head == null || head.next == null) {
            return head;
        }
        int count = 0;
        ListNode currentNode = head;
        while (count != k && currentNode != null) {
            currentNode = currentNode.next;
            count++;
        }
        if (count == k) {
            currentNode = reverseKGroup(currentNode, k);
            while (count-- > 0) {
                ListNode temp = head.next;
                head.next = currentNode;
                currentNode = head;
                head = temp;
            }
            head = currentNode;
        }
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
