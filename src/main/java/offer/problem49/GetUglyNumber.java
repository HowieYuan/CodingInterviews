package offer.problem49;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 49. 丑数
 * @Date 2019-02-04
 * @Time 16:45
 */
public class GetUglyNumber {
    /**
     * 方案1：逐个判断整数，但效率过慢
     */
    public int solution1(int index) {
        if (index <= 0) {
            return 0;
        }
        int num = 0;
        while (index != 0) {
            num++;
            while (!isUgly(num)) {
                num++;
            }
            index--;
        }
        return num;
    }

    /**
     * 方案2：创建一个大小为 index 的数字
     */
    private int solution2(int index) {
        if (index <= 0) {
            return 0;
        }
        // 定义一个存放丑数的数组
        int[] uglyList = new int[index];
        // 1 是所有丑数排序后第一个
        uglyList[0] = 1;
        // 下一个丑数的索引，同时也表示着当前数组的个数
        int nextUglyIndex = 1;

        // 2、3、5因子的索引
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;

        // 当 nextUglyIndex+1=index 时，会构造 uglyList[nextUglyIndex]，即所求丑数
        while (nextUglyIndex < index) {
            // 从找到的三个数中选出最小的一个数加入到数组中
            int min = minNum(uglyList[p2] * 2, uglyList[p3] * 3, uglyList[p5] * 5);
            uglyList[nextUglyIndex] = min;
            while (uglyList[p2] * 2 <= uglyList[nextUglyIndex]) {
                // 找到第一个数 * 2 > 当前数组中最大丑数的索引
                p2++;
            }
            while (uglyList[p3] * 3 <= uglyList[nextUglyIndex]) {
                // 找到第一个数 * 3 > 当前数组中最大丑数的索引
                p3++;
            }
            while (uglyList[p5] * 5 <= uglyList[nextUglyIndex]) {
                // 找到第一个数 * 5 > 当前数组中最大丑数的索引
                p5++;
            }
            // 移动索引
            nextUglyIndex++;
        }
        // 注意这里-1操作
        return uglyList[nextUglyIndex - 1];
    }

    /**
     * 找到三个数中的最小值
     *
     * @param a 数a
     * @param b 数b
     * @param c 数c
     * @return 返回最小值
     */
    private int minNum(int a, int b, int c) {
        int min = a > b ? b : a;
        return min > c ? c : min;
    }


    /**
     * 某数是否是丑数
     */
    private boolean isUgly(int num) {
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }

    public static void main(String[] args) {
        System.out.println(new GetUglyNumber().solution2(1500));
    }
}
