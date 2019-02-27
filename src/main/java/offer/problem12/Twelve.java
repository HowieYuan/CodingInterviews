package offer.problem12;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description p89  12. 矩阵中的路径
 * @Date 2018-11-27
 * @Time 15:40
 */
public class Twelve {
    /**
     * 回溯法：
     * 判断矩阵中是否存在一条路径
     *
     * @param matrix 输入矩阵
     * @param rows   矩阵行数
     * @param cols   矩阵列数
     * @param str    要搜索的字符串
     * @return 若找到返回true，否则返回false
     */
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows <= 0 || cols <= 0 || matrix.length != rows * cols ||
                str == null || str.length < 1) {
            return false;
        }
        boolean[] visit = new boolean[rows * cols];
        int length = 0;
        //两层嵌套循环矩阵，一个个位置遍历
        for (int row = 0; row <= rows; row++) {
            for (int col = 0; col <= cols; col++) {
                //当前位置的字符和字符串的字符是否相等？如果相等的话则递归检查上下左右位置的字符
                if (hasPathCore(matrix, rows, row, cols, col, str, visit, length)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 回溯搜索算法
     *
     * @param matrix 输入矩阵
     * @param rows   矩阵行数
     * @param cols   矩阵列数
     * @param row    当前处理列号
     * @param col    当前处理行号
     * @param str    要搜索的字符串
     * @param length 已经处理的str中字符个数
     * @param visit  访问标记数组
     * @return 若找到返回true，否则返回false
     */
    public static boolean hasPathCore(char[] matrix, int rows, int row, int cols,
                                      int col, char[] str, boolean[] visit, int length) {
        if (length == str.length) {
            return true;
        }
        if (row >= 0 && row < rows && col >= 0 && col < cols &&
                str[length] == matrix[row * cols + col] && !visit[row * cols + col]) {
            length++;
            visit[row * cols + col] = true;
            //上下左右四种情况
            if (hasPathCore(matrix, rows, row + 1, cols, col, str, visit, length)
                    || hasPathCore(matrix, rows, row, cols, col + 1, str, visit, length)
                    || hasPathCore(matrix, rows, row - 1, cols, col, str, visit, length)
                    || hasPathCore(matrix, rows, row, cols, col - 1, str, visit, length)) {
                return true;
            }
            visit[row * cols + col] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasPath(new char[]{'A', 'B', 'C', 'E', 'S', 'F', 'C', 'S', 'A', 'D', 'E', 'E'},
                3, 4, new char[]{'A', 'B', 'C', 'C', 'E', 'D'}));
    }
}
