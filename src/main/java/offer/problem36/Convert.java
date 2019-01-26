package offer.problem36;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 36. 二叉搜索树与双向链表
 * @Date 2019-01-26
 * @Time 22:26
 */
public class Convert {
    public TreeNode convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return pRootOfTree;
        }
        TreeNode lastNodeList = null;
        lastNodeList = convertNode(pRootOfTree, lastNodeList);
        while (lastNodeList.left != null) {
            lastNodeList = lastNodeList.left;
        }
        return lastNodeList;
    }

    private TreeNode convertNode(TreeNode currentNode, TreeNode lastNodeList) {
        if (currentNode == null) {
            return null;
        }
        if (currentNode.left != null) {
            // 先遍历并构造其左子树
            lastNodeList = convertNode(currentNode.left, lastNodeList);
        }
        // 对接结点与其左子树的关系
        currentNode.left = lastNodeList;
        if (lastNodeList != null) {
            lastNodeList.right = currentNode;
        }

        // 注意：这里链表最后一个节点转化为当前节点
        lastNodeList = currentNode;

        if (currentNode.right != null) {
            // 遍历并构造右子树
            lastNodeList = convertNode(currentNode.right, lastNodeList);
        }
        return lastNodeList;
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private static void showList(TreeNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.right;
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right = new TreeNode(14);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);

        TreeNode head = new Convert().convert(root);
        showList(head);
    }
}
