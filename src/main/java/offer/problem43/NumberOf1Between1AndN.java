package offer.problem43;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description
 * @Date 2019-01-31
 * @Time 12:32
 */
public class NumberOf1Between1AndN {
    /**
     * 输入一个整数n求从1 到n这n个整数的十进制表示中1 出现的次数
     * 不考虑时间效率的算法
     * @param n 最大的数字
     * @return 1-n中，各个数位1出现的次数
     */
    private static int solution1(int n) {
        if (n < 0) {
            return 0;
        }
        int count = 0;
        // 从1开始递加到n，并岁每一个数进行检查其1的个数
        for (int i=1; i<=n; i++) {
            count += numberOf1Two(i);
        }
        return count;
    }

    /**
     * 统计一个大于0的整数中位数出现1的次数
     * @param n 大于0的整数
     * @return 1的个数
     */
    private static int numberOf1Two(int n) {
        int count = 0;
        while (n != 0) {
            if (n % 10 == 1) {
                count++;
            }
            n = n/10;
        }
        return count;
    }


    /**
     * 输入一个整数n求从1 到n这n个整数的十进制表示中1 出现的次数
     *
     * @param n 最大的数字
     * @return 1-n中，各个数位1出现的次数
     */
    private static int solution2(int n) {
        if (n < 0) {
            return 0;
        }
        // 转化为字符串
        String value = n + "";
        int[] number = new int[value.length()];

        for (int i = 0; i < number.length; i++) {
            number[i] = value.charAt(i) - '0';
        }
        return numberOf1(number, 0);
    }

    /**
     * 求0-numbers表的数字中的1的个数
     *
     * @param number   数字
     * @param curIndex 当前处理的位置
     * @return 1的个数
     */
    private static int numberOf1(int[] number, int curIndex) {
        if (number == null || curIndex >= number.length || curIndex < 0) {
            return 0;
        }
        // 记录待处理的第一个数字
        int firstNum = number[curIndex];
        // 记录待处理数组长度
        int length = number.length - curIndex;

        // 如果只有一个0，返回0
        if (length == 1 && firstNum == 0) {
            return 0;
        }
        // 如果只有一个大于0的一位数，返回1
        if (length == 1 && firstNum > 0) {
            return 1;
        }
        int numFirstDigit = 0;
        if (firstNum > 1) {
            numFirstDigit = powerBase10(length - 1);
        } else if (firstNum == 1) {
            numFirstDigit = atoi(number, curIndex + 1) + 1;
        }

        int numOtherDigit = firstNum * (length - 1) * powerBase10(length - 2);
        int numRecursive = numberOf1(number, curIndex + 1);

        return numFirstDigit + numOtherDigit + numRecursive;
    }

    /**
     * 将数字数组转化为数值
     *
     * @param number 数组
     * @param index  开始转换索引坐标
     * @return 转换结果
     */
    private static int atoi(int[] number, int index) {
        int result = 0;
        for (int i = index; i < number.length; i++) {
            result = (result * 10 + number[i]);
        }
        return result;
    }

    /**
     * 求10的n次方
     *
     * @param n 指数
     * @return 10的n次方
     */
    private static int powerBase10(int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= 10;
        }
        return result;
    }


}
