package offer.problem32;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 32.3 之字形逐行打印二叉树
 * @Date 2019-01-25
 * @Time 12:40
 */
public class PrintTreeInZigzag {
    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (pRoot == null) {
            return list;
        }
        Stack<TreeNode> currentStack = new Stack<>();
        Stack<TreeNode> nextStack = new Stack<>();
        int flag = 1;
        ArrayList<Integer> currentList = new ArrayList<>();
        currentStack.push(pRoot);
        while (!currentStack.isEmpty()) {
            TreeNode node = currentStack.pop();
            if (flag == 1) {
                if (node.left != null) {
                    nextStack.push(node.left);
                }
                if (node.right != null) {
                    nextStack.push(node.right);
                }
            } else {
                if (node.right != null) {
                    nextStack.push(node.right);
                }
                if (node.left != null) {
                    nextStack.push(node.left);
                }
            }
            currentList.add(node.val);
            if (currentStack.isEmpty()) {
                list.add(currentList);
                currentList = new ArrayList<>();
                currentStack = nextStack;
                nextStack = new Stack<>();
                flag = 1 - flag;
            }
        }
        return list;
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
