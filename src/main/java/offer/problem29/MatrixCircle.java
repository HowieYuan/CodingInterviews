package offer.problem29;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 29. 顺时针打印矩阵
 * @Date 2019-01-23
 * @Time 23:19
 */
public class MatrixCircle {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int x = 0, y = 0;
        //rows > 2 * x 且 columns > 2 * y 即可循环当前圈
        while (matrix.length > x * 2 && matrix[0].length > y * 2) {
            getCircle(matrix, x, y, list);
            //准备进入下一圈
            x++;
            y++;
        }
        return list;
    }

    private void getCircle(int[][] matrix, int x, int y, List<Integer> list) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int endX = rows - 1 - x;
        int endY = columns - 1 - y;
        //从左到右
        for (int i = y; i <= endY; i++) {
            list.add(matrix[x][i]);
        }
        //如果遇到只有 从左到右 一行的情况，则第一次循环之后即可跳过
        if (x >= endX) {
            return;
        }
        //从上到下
        for (int i = x + 1; i <= endX; i++) {
            list.add(matrix[i][endY]);
        }
        //从右到左
        for (int i = endY - 1; i >= y; i--) {
            list.add(matrix[endX][i]);
        }
        //如果遇到只有 从上到下 一列的情况，则跳过最后一次循环
        if (y >= endY) {
            return;
        }
        //从下到上
        for (int i = endX - 1; i > x; i--) {
            list.add(matrix[i][y]);
        }
    }
}
