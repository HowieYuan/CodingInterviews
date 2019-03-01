package offer.problem28;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 28. 判断树的对称
 * @Date 2019-01-23
 * @Time 15:28
 */
public class SymmetricalTree {
    public boolean isSymmetrical(TreeNode pRoot) {
        //传入两个pRoot， 将树自己与自己作对比
        return checkSymmetrical(pRoot, pRoot);
    }

    private boolean checkSymmetrical(TreeNode pRoot1, TreeNode pRoot2) {
        if (pRoot1 == null && pRoot2 == null) {
            return true;
        }
        if (pRoot1 != null && pRoot2 != null && pRoot1.val == pRoot2.val) {
            //左子树的左子树对应右子树的右子树；左子树的右子树对应右子树的左子树
            return checkSymmetrical(pRoot1.left, pRoot2.right)
                    && checkSymmetrical(pRoot1.right, pRoot2.left);
        }
        return false;
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
