package offer.problem18;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description p122  18.2 删除链表中重复节点
 * @Date 2018-12-02
 * @Time 14:48
 */
public class DeleteDuplication {
    /**
     * 迭代
     */
    public static ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null || pHead.next != null) {
            return pHead;
        }
        ListNode head = new ListNode(0);
        head.next = pHead;
        ListNode pre = head;
        while(pHead != null && pHead.next != null) {
            if(pHead.next.val == pHead.val) {
                while(pHead.next != null && pHead.next.val == pHead.val) {
                    pHead = pHead.next;
                }
                pre.next = pHead.next;
            } else {
                pre = pre.next;
            }
            pHead = pHead.next;
        }
        return head.next;
    }

    /**
     * 递归
     */
    public static ListNode deleteDuplication2(ListNode pHead) {
        if(pHead == null || pHead.next == null) {
            return pHead;
        }
        if(pHead.next.val == pHead.val) {
            while(pHead.next != null && pHead.next.val == pHead.val) {
                pHead = pHead.next;
            }
            return deleteDuplication(pHead.next);
        } else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
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
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(4);
        listNode.next.next.next = new ListNode(5);
        listNode.next.next.next.next = new ListNode(6);
        System.out.println(deleteDuplication(listNode));
        System.out.println(1);
    }
}
