package offer.problem54;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 54. 二叉搜索树第 K 大节点
 * @Date 2019-02-09
 * @Time 16:47
 */
public class KthNode {
    //计数器
    int index = 0;

    public TreeNode solution(TreeNode root, int k) {
        //中序遍历寻找第k个
        if (root != null) {
            TreeNode node = solution(root.left, k);
            if (node != null) {
                return node;
            }
            index++;
            if (index == k) {
                return root;
            }
            node = solution(root.right, k);
            return node;
        }
        return null;
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(7);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(8);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        // 2
//        System.out.println(traversing(n1));
        // 4
//        System.out.println(traversing(n1, 3));
//        // null
//        System.out.println(traversing(n1, 8));
    }
}
