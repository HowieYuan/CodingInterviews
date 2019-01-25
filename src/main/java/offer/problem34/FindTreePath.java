package offer.problem34;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 34. 二叉树中和为某一值的路径
 * @Date 2019-01-25
 * @Time 21:09
 */
public class FindTreePath {
    public ArrayList<ArrayList<Integer>> find(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<Integer> stack = new Stack<>();
        getPath(root, target, 0, list, stack);
        return list;
    }

    private void getPath(TreeNode node, int target, int sum, ArrayList<ArrayList<Integer>> list,
                         Stack<Integer> stack) {
        sum += node.val;
        //及时剪枝
        if (sum <= target) {
            stack.push(node.val);
            //满足条件
            if (node.left == null && node.right == null && sum == target) {
                list.add(new ArrayList<>(stack));
                //出栈，回溯上一个点
                stack.pop();
                return;
            }
            //左子树
            if (node.left != null) {
                getPath(node.left, target, sum, list, stack);
            }
            //右子树
            if (node.right != null) {
                getPath(node.right, target, sum, list, stack);
            }
            //出栈，回溯上一个点
            stack.pop();
        }
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
        TreeNode root = new TreeNode(10);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(7);
        root.left = new TreeNode(12);

        System.out.println("查找期望值为22的路径：");
        List list = new FindTreePath().find(root, 22);
        System.out.println(list);
    }
}
