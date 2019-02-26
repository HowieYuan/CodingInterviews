package offer.problem07;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description P62 重建二叉树
 * @Date 2018-10-25
 * @Time 22:20
 */
public class Seven {
    /**
     * @param pre 前序遍历序列
     * @param in  中序遍历序列
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return getTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    /**
     * @param pre 前序遍历序列
     * @param pl  前序遍历当前递归起始位置
     * @param ph  前序遍历当前递归终点位置
     * @param in  中序遍历序列
     * @param il  中序遍历当前递归起始位置
     * @param ih  中序遍历当前递归终点位置
     */
    public TreeNode getTree(int[] pre, int pl, int ph,
                            int[] in, int il, int ih) {
        if (pl > ph || il > ih) {
            return null;
        }
        //前序遍历的首元素即为当前子树根结点
        TreeNode node = new TreeNode(pre[pl]);
        for (int i = il; i <= ih; i++) {
            //找到中序遍历中当前子树根结点位置
            if (in[i] == pre[pl]) {
                //左子树
                node.left = getTree(pre, pl + 1, pl + i - il, in, il, i - 1);
                //右子树
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
