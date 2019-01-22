package offer.problem26;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 26. 树的子结构
 * @Date 2019-01-23
 * @Time 1:50
 */
public class HasSubtree {
    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return check(root1, root2);
    }

    private boolean check(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        return ((root1.val == root2.val) && check(root1.left, root2.left) && check(root1.right, root2.right))
                || check(root1.left, root2)
                || check(root1.right, root2);
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
