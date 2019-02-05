package offer.problem51;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 51. 数组中的逆序对
 * @Date 2019-02-05
 * @Time 15:55
 */
public class InversePairsCode {
    /**
     * 统计数组中逆序对数目
     *
     * @param data 给定数组
     * @return 数组中逆序对数目
     */
    private static int solution(int[] data) {
        if (data == null || data.length <= 1) {
            return 0;
        }
        int[] copy = new int[data.length];
        System.arraycopy(data, 0, copy, 0, data.length);
        return inversePairsCode(data, copy, 0, data.length - 1);
    }

    /**
     * 统计数组中逆序对个数
     * 归并排序算法
     *
     * @param data  给定数组
     * @param copy  复制数组
     * @param start 起始索引
     * @param end   终止索引
     * @return 数组中逆序对个数
     */
    private static int inversePairsCode(int[] data, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = data[start];
            return 0;
        }
        int middle = (end + start) / 2;
        //分治：左
        int left = inversePairsCode(copy, data, start, middle);
        //分治：右
        int right = inversePairsCode(copy, data, middle + 1, end);

        // 对当前排序好的两个子数组进行逆序对统计
        // 如， 2与4、1与3 的逆序对为 2
        int i = middle;
        int j = end;
        int index = end;
        // 两个子数组对比的逆序对数
        int count = 0;
        while (i >= start && j >= middle + 1) {
            if (data[i] > data[j]) {
                copy[index--] = data[i--];
                //关键一步，当个 data[i] > data[j]，则 data[i] 大于 j 到 middle + 1 之间的数
                count += (j - middle);
            } else {
                copy[index--] = data[j--];
            }
        }

        // 将没有排序的元素并入数组
        for (; i >= start; i--) {
            copy[index--] = data[i];
        }
        for (; j >= middle + 1; j--) {
            copy[index--] = data[j];
        }
        return left + right + count;
    }

    public static void main(String[] args) {
        int[] data = {7, 5, 6, 4};
        // 5
        System.out.println(solution(data));
        int[] data2 = {6, 5, 4, 3, 2, 1};
        // 5+4+3+2+1=15
        System.out.println(solution(data2));
        int[] data3 = {1, 2, 3};
        // 0
        System.out.println(solution(data3));
    }
}
