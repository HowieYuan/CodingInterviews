package offer;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 二叉树的下一个结点
 * @Date 2018-11-01
 * @Time 16:49
 */
public class Eight {
    public TreeLinkNode getNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        //当右子树不为空，则下一个结点为右子树中的最左子节点
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        //当右子树为空，则下一节点为父节点以上（或者没有下一节点）
        while (pNode.next != null) {
            //一直往上遍历，找到第一个以当前结点为左结点的父节点
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
