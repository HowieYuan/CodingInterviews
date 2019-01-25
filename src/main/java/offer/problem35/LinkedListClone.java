package offer.problem35;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 35. 复杂链表的复制
 * @Date 2019-01-25
 * @Time 22:05
 */
public class LinkedListClone {
    public RandomListNode clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        if (pHead.next == null) {
            return new RandomListNode(pHead.val);
        }
        //复制链表
        cloneNodes(pHead);
        //分割链表
        return reconnectNodes(pHead);
    }

    private void cloneNodes(RandomListNode pHead) {
        RandomListNode currentNode = pHead;
        //复制后继结点
        while (currentNode != null) {
            RandomListNode node = new RandomListNode(currentNode.val);
            node.next = currentNode.next;
            currentNode.next = node;
            currentNode = currentNode.next.next;
        }
        //复制 sibling 结点
        currentNode = pHead;
        while (currentNode != null) {
            if (currentNode.sibling != null) {
                currentNode.next.sibling = currentNode.sibling.next;
            }
            currentNode = currentNode.next.next;
        }
    }

    /**
     * 分割链表
     */
    private RandomListNode reconnectNodes(RandomListNode pHead) {
        RandomListNode head = pHead.next;
        RandomListNode node = pHead;
        while (node.next != null) {
            RandomListNode next = node.next;
            node.next = node.next.next;
            node = next;
        }
        return head;
    }

    public static class RandomListNode {
        int val;
        RandomListNode next = null;
        RandomListNode sibling = null;

        RandomListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        RandomListNode node5 = new RandomListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node1.sibling = node3;
        node2.sibling = node5;
        node4.sibling = node2;
        RandomListNode result = new LinkedListClone().clone(node1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
