package offer.problem32;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 32.2. 分行从上到下打印二叉树
 * @Date 2019-01-25
 * @Time 2:00
 */
public class PrintTreeInLines {
    ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (pRoot == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int nextNode = 0;
        int currentNode = 1;
        ArrayList<Integer> currentList = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
                nextNode++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextNode++;
            }
            currentList.add(node.val);
            currentNode--;
            if (currentNode == 0) {
                list.add(currentList);
                currentList = new ArrayList<>();
                currentNode = nextNode;
                nextNode = 0;
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
