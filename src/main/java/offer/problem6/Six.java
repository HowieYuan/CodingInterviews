package offer.problem6;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description P58 从尾到头打印链表
 * @Date 2018-10-24
 * @Time 18:46
 */
public class Six {
    /**
     * 使用栈来先进后出
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        return list;
    }

    /**
     * 使用递归
     */
    private ArrayList<Integer> arrayList = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if (listNode != null) {
            this.printListFromTailToHead2(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
