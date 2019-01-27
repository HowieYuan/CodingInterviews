package offer.problem37;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 37. 序列化二叉树
 * @Date 2019-01-27
 * @Time 15:16
 */
public class SerializeTree {
    /**
     * 序列化
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        String str = "";
        return serializeTree(root, str).replaceFirst(", ", "");
    }

    private String serializeTree(TreeNode root, String str) {
        if (root == null) {
            str += ", #";
            return str;
        }
        str += ", " + root.val;
        str = serializeTree(root.left, str);
        str = serializeTree(root.right, str);
        return str;
    }

    /**
     * 反序列化
     */
    private static int index = 0;

    public static TreeNode deserialize(String str) {
        if (str == null || str.length() < 1) {
            return null;
        }
        index = 0;
        return deserializeSolve(str.split(", "));
    }

    private static TreeNode deserializeSolve(String[] chars) {
        String hashTag = "#";
        if (hashTag.equals(chars[index])) {
            index++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(chars[index]));
        index++;
        node.left = deserializeSolve(chars);
        node.right = deserializeSolve(chars);
        return node;
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
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        String str = new SerializeTree().serialize(n1);
        System.out.println("打印序列化结果：");
        System.out.println(str);
        TreeNode node = deserialize(str);
        System.out.println("执行反序列化并打印结果：");
        print(node);
    }

    /**
     * 先序遍历打印二叉树
     *
     * @param root 二叉树根结点
     */
    private static void print(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            print(root.left);
            print(root.right);
        }
    }

}
