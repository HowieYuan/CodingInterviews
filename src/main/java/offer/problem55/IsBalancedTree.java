package offer.problem55;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 55.2. 二叉树是否是平衡二叉树
 * @Date 2019-02-09
 * @Time 21:23
 */
public class IsBalancedTree {
    /**
     * 方案一：利用获取深度的方法一次递归左右子树
     */
    public boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = getDepth1(root.left);
        int rightDepth = getDepth1(root.right);
        if (leftDepth - rightDepth > 1 || leftDepth - rightDepth < -1) {
            return false;
        }
        return isBalanced1(root.left) && isBalanced1(root.right);
    }

    private int getDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;
        int leftDepth = getDepth1(root.left);
        int rightDepth = getDepth1(root.right);
        return depth + (leftDepth > rightDepth ? leftDepth : rightDepth);
    }

    /**
     * 方案2：后序遍历
     */
    public boolean isBalanced2(TreeNode root) {
        return getDepth2(root) != -1;
    }

    private int getDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth2(root.left);
        if (left == -1) {
            return -1;
        }
        int right = getDepth2(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
