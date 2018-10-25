/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description P62 重建二叉树
 * @Date 2018-10-25
 * @Time 22:20
 */
public class Seven {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return getTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public TreeNode getTree(int[] pre, int pl, int ph,
                            int[] in, int il, int ih) {
        if (pl > ph || il > ih) {
            return null;
        }
        TreeNode node = new TreeNode(pre[pl]);
        for (int i = il; i <= ih; i++) {
            if (in[i] == pre[pl]) {
                node.left = getTree(pre, pl + 1, pl + i - il, in, il, i - 1);
                node.right = getTree(pre, pl + i - il + 1, ph, in, i + 1, ih);
                break;
            }
        }
        return node;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
