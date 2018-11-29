package offer.problem13;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description p92   13. 机器人的运动范围
 * @Date 2018-11-27
 * @Time 16:22
 */
public class Thirteen {
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows < 1 || cols < 1) {
            return 0;
        }
        int result = 0;
        boolean[] visited = new boolean[rows * cols];
        return getSum(threshold, rows, 0, cols, 0, visited);
    }

    public int getSum(int threshold, int rows, int row, int cols, int col, boolean[] visited) {
        if (row >= 0 && col >= 0 && row < rows && col < cols && !visited[row * cols + col] &&
                (row / 10 + row % 10 + col / 10 + col % 10) <= threshold) {
            visited[row * cols + col] = true;
            return 1 + getSum(threshold, rows, row + 1, cols, col, visited) +
                    getSum(threshold, rows, row, cols, col + 1, visited) +
                    getSum(threshold, rows, row - 1, cols, col, visited) +
                    getSum(threshold, rows, row, cols, col - 1, visited);
        }
        return 0;
    }
}
