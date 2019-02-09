package offer.problem55;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 55.1. 二叉树的深度
 * @Date 2019-02-09
 * @Time 21:10
 */
public class TreeDepth {
    public int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;
        int leftDepth = solution(root.left);
        int rightDepth = solution(root.right);
        return depth + (leftDepth > rightDepth ? leftDepth : rightDepth);
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
