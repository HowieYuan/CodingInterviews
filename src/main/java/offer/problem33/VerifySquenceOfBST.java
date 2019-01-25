package offer.problem33;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 33. 二叉搜索树的后序遍历序列
 * @Date 2019-01-25
 * @Time 17:53
 */
public class VerifySquenceOfBST {
    public boolean verifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int start, int end) {
        if (start == end) {
            return true;
        }
        //获得根结点
        int root = sequence[end];
        int nextLeftEnd = start;
        //检查左子树范围
        while (nextLeftEnd < end && sequence[nextLeftEnd] < root) {
            nextLeftEnd++;
        }
        //检查右子树正确性
        int nextRightEnd = nextLeftEnd;
        while (nextRightEnd < end) {
            //发现右子树有小于根结点的，返回false
            if (sequence[nextRightEnd] < root) {
                return false;
            }
            nextRightEnd++;
        }
        //递归
        boolean left = true;
        if (nextLeftEnd > start) {
            left = verify(sequence, start, nextLeftEnd - 1);
        }
        boolean right = true;
        if (nextLeftEnd < end) {
            right = verify(sequence, nextLeftEnd, nextRightEnd - 1);
        }
        return left && right;
    }

    public static void main(String[] args) {
        System.out.println(new VerifySquenceOfBST().verifySquenceOfBST(new int[]{5, 7, 6, 9, 11, 10, 8, 16}));
    }
}
