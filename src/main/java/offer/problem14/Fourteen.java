package offer.problem14;

import static java.lang.Math.pow;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description P96  14. 剪绳子
 * @Date 2018-11-28
 * @Time 15:44
 */
public class Fourteen {
    /**
     * 动态规划法
     * O(n^2)
     */
    public static int cutting(int length) {
        if (length < 2) {
            return 0;
        }
        //长度为2，剪成1，1，乘积为1
        if (length == 2) {
            return 1;
        }
        //长度为3，剪成1，2，乘积为2
        if (length == 3) {
            return 2;
        }
        int[] dp = new int[length + 1];
        dp[1] = 1;
        //当遇到长度为2的子绳子时，如果继续剪，最大只能是1，所以保留其本身长度，即2
        dp[2] = 2;
        //当遇到长度为3的子绳子时，如果继续剪，最大只能是2，所以保留其本身长度，即3
        dp[3] = 3;
        for (int i = 4; i < dp.length; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int sum = dp[j] * dp[i - j];
                max = sum > max ? sum : max;
                dp[i] = max;
            }
        }
        return dp[length];
    }

    /**
     * 贪婪算法（主要是数学功力）
     * O(1)
     * 尽可能多地剪出长度为3的绳子，这样为最大
     */
    public static int cutting2(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        // 尽可能多地减去长度为3的绳子段
        int timesOf3 = length / 3;
        // 当绳子最后剩下的长度为4的时候，不能再剪去长度为3的绳子段。
        // 此时更好的方法是把绳子剪成长度为2的两段，因为2*2 > 3*1。
        if (length - timesOf3 * 3 == 1) {
            timesOf3 -= 1;
        }
        int timesOf2 = (length - timesOf3 * 3) / 2;
        return (int) (pow(3, timesOf3)) * (int) (pow(2, timesOf2));
    }

    public static void main(String[] args) {
        System.out.println(cutting(7) + "expected: 12");
        System.out.println(cutting(8) + "expected: 18");
        System.out.println(cutting(9) + "expected: 27");
        System.out.println(cutting(10) + "expected: 36");
        System.out.println(cutting(50) + "expected: 86093442");
    }
}
