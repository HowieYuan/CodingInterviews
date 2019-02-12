package offer.problem66;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 66. 构建乘积数组
 * @Date 2019-02-12
 * @Time 17:16
 */
public class Multiply {
    /**
     * 构建乘积数组
     *
     * @param data 原数组
     * @return 乘积数组
     */
    private static int[] multiply(int[] data) {
        if (data == null || data.length < 2) {
            return null;
        }
        int[] result = new int[data.length];

        /*
        B[i] = A[0]*A[1]*……*A[i-1]*A[i+1]*……*A[n-1]
        转化为 B[i]=C[i]*D[i]
        其中，C[i] = A[0]*A[1]*……*A[i-1]；D[i] = A[i+1]*……*A[n-1]。
         */

        // result[0] 取 1
        result[0] = 1;
        // 计算所有的 C[i]，存放于数组中
        for (int i = 1; i < data.length; i++) {
            // 当 i=data.length-1 时，得到最重要的 result[n-1]
            result[i] = result[i - 1] * data[i - 1];
        }

        int temp = 1;
        // 计算所有的D[i]，存储在 temp 中，并与原数组相乘合并
        for (int i = data.length - 2; i >= 0; i--) {
            temp *= data[i + 1];
            result[i] *= temp;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5};
        // 120, 60, 40, 30, 24
        System.out.println(Arrays.toString(multiply(data)));
    }
}
