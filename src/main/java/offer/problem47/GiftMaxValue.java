package offer.problem47;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 47. 礼物的最大价值
 * @Date 2019-02-04
 * @Time 14:25
 */
public class GiftMaxValue {
    /**
     * 动态规划
     * f(i, j) = Max(f(i - 1, j), f(i, j - 1)) + value(i, j)
     */
    public int solution1(int[][] values) {
        if (values.length <= 0 || values[0].length <= 0) {
            return 0;
        }
        int rows = values.length;
        int column = values[0].length;
        int[][] maxValue = new int[rows][column];
        //给 (0, 0) 赋值
        maxValue[0][0] = values[0][0];
        //先给第一行赋值
        for (int i = 1; i < rows; i++) {
            maxValue[i][0] = maxValue[i - 1][0] + values[i][0];
        }
        //再给第一列赋值
        for (int j = 1; j < column; j++) {
            maxValue[0][j] = maxValue[0][j - 1] + values[0][j];
        }
        //然后从 (1, 1) 开始利用 f(i, j) = Max(f(i - 1, j), f(i, j - 1)) + value(i, j) 计算
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < column; j++) {
                maxValue[i][j] = Math.max(maxValue[i - 1][j], maxValue[i][j - 1]) + values[i][j];
            }
        }
        return maxValue[rows - 1][column - 1];
    }

    /**
     * 动态规划 + 一维数组
     * f(j) = Max(f(j), f(j - 1)) + value(i, j)
     *
     * maxValue 数组的长度是 column，value 数组逐行更新 maxValue 数组
     */
    public int solution2(int[][] values) {
        if (values.length <= 0 || values[0].length <= 0) {
            return 0;
        }
        int rows = values.length;
        int column = values[0].length;
        int[] maxValue = new int[column];
        //给 (0, 0) 赋值
        maxValue[0] = values[0][0];
        //先给第一列赋值
        for (int j = 1; j < column; j++) {
            maxValue[j] = maxValue[j - 1] + values[0][j];
        }
        //然后从 (1, 0) 开始计算
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                if (j == 0) {
                    maxValue[j] = maxValue[j] + values[i][j];
                } else {
                    maxValue[j] = Math.max(maxValue[j - 1], maxValue[j]) + values[i][j];
                }
            }
        }
        return maxValue[column - 1];
    }

    public static void main(String[] args) {
        int[][] values =
                new int[][]{{1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}};
        System.out.println(new GiftMaxValue().solution2(values));
    }
}
