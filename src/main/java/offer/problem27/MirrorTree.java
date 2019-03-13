package offer.problem27;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 27. 二叉树的镜像
 * @Date 2019-01-23
 * @Time 15:04
 */
public class MirrorTree {
    /**
     * 递归
     */
    public void mirror(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            //这里判断可以不加
            if (root.left != null) {
                mirror(root.left);
            }
            if (root.right != null) {
                mirror(root.right);
            }
        }
    }

    /**
     * 循环迭代
     */
    public void mirror2(TreeNode root) {
        if (root == null) {
            return;
        }
        //使用栈也可以
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            TreeNode temp =  node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
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
