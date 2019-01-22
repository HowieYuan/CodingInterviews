package offer.problem23;


/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 23.链表中环的入口结点
 *              对应leetcode 链表 142 题，还有两种解法
 * @Date 2019-01-22
 * @Time 23:00
 */
public class EntryNodeOfLoop {
    public static ListNode entryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        //获得环内点
        ListNode meetingNode = meeting(pHead);
        if (meetingNode == null) {
            return null;
        }
        ListNode node = meetingNode.next;
        int length = 1;
        //通过环内点获得环的长度 n
        while (meetingNode.val != node.val) {
            node = node.next;
            length++;
        }
        ListNode fast = pHead, slow = pHead;
        //快指针先前进 n 位，然后快慢指针同步走，两指针汇合处即入口点
        while (length-- > 0) {
            fast = fast.next;
        }
        while (fast.val != slow.val) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    /**
     * 利用快慢指针，检查是否存在环，并返回环里面的其中一个结点
     *
     * @return 环里面的其中一个结点
     */
    private static ListNode meeting(ListNode pHead) {
        ListNode fast = pHead, slow = pHead;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next;
            }
            if (fast.val == slow.val) {
                return fast;
            }
        }
        return null;
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

        // 单链表
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        // null
        System.out.println(entryNodeOfLoop(n1));

        // 构成环
        n6.next = n3;
        // n3
        System.out.println(entryNodeOfLoop(n1));
    }
}
