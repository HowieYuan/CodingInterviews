package offer.problem25;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 25. 合并两个排序的链表
 * @Date 2019-01-23
 * @Time 1:13
 */
public class MergeSortedList {
    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        //获得头结点
        ListNode resultList;
        if (list1.val < list2.val) {
            resultList = list1;
            list1 = list1.next;
        } else {
            resultList = list2;
            list2 = list2.next;
        }
        ListNode head = resultList;
        //分别取两个链表的值比较
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                resultList.next = list1;
                list1 = list1.next;
            } else {
                resultList.next = list2;
                list2 = list2.next;
            }
            resultList = resultList.next;
        }
        //处理剩余的结点
        if (list1 != null) {
            resultList.next = list1;
        } else {
            resultList.next = list2;
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
