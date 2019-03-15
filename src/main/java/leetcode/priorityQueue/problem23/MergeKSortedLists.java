package leetcode.priorityQueue.problem23;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 23. Merge k Sorted Lists (合并K个排序链表)
 * @Date 2019-03-15
 * @Time 15:34
 */
public class MergeKSortedLists {
    public ListNode solution(ListNode[] lists) {
        if (lists.length <= 0) {
            return null;
        }
        //利用优先队列
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        ListNode result = new ListNode(0);
        ListNode currentNode = result;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            currentNode.next = node;
            currentNode = currentNode.next;

            if (node.next != null) {
                queue.add(node.next);
            }
        }
        return result.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }
}
