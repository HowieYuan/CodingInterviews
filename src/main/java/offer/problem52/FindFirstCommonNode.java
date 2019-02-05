package offer.problem52;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 52. 两个链表的第一个公共结点
 * @Date 2019-02-05
 * @Time 20:33
 */
public class FindFirstCommonNode {
    /**
     * 方案1：利用栈存放链表结点，然后从尾结点开始检查
     */
    public ListNode solution1(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (pHead1 != null) {
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }
        ListNode node1 = null, node2 = null;
        while (!stack1.empty() && !stack2.empty() && stack1.peek() == stack2.peek()) {
            node1 = stack1.pop();
            node2 = stack2.pop();
        }
        if (node1 != null && node2 != null && node1 == node2) {
            return node1;
        } else {
            return null;
        }
    }

    /**
     * 方案2：获得两个链表的长度，让长的链表先走若干步再同时遍历
     */
    public ListNode solution2(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        //获得两个链表长度
        ListNode temp1 = pHead1, temp2 = pHead2;
        int length1 = 0, length2 = 0;
        while (temp1 != null) {
            length1++;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            length2++;
            temp2 = temp2.next;
        }
        //检查哪个为长链表
        ListNode longNode = pHead1, shortNode = pHead2;
        int lengthDif = length1 - length2;
        if (length2 > length1) {
            longNode = pHead2;
            shortNode = pHead1;
            lengthDif = length2 - length1;
        }
        //长链表先走若干步
        while (lengthDif-- > 0) {
            longNode = longNode.next;
        }
        //两链表同起跑线，开始检查公共结点
        while (longNode != shortNode) {
            longNode = longNode.next;
            shortNode = shortNode.next;
        }
        if (longNode == null) {
            return null;
        } else {
            return longNode;
        }
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n6;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        System.out.println(new FindFirstCommonNode().solution2(n1, n4).toString());
    }
}
