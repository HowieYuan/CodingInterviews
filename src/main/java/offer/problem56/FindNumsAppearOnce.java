package offer.problem56;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 56. 数组中只出现一次的两个数字
 * @Date 2019-02-10
 * @Time 14:03
 */
public class FindNumsAppearOnce {
    /**
     * 异或求解
     *
     * 原理：
     * 2 ^ 1 ^ 2 = 1，如果只有一个数组出现一次，那么一次异或最后得到的数字必定是答案
     * 当数组中有两个只出现一次的数字时，我们将所有数字一次异或，在结果必定不等于0，至少有一位是1
     * 按m位为1和为0将数组分为两个数组，此时只出现一次的两个数就被分到了不同的组
     * 然后再按一开始的方法分别找出两个数字
     */
    public void solution(int[] array, int num1[], int num2[]) {
        if (array.length <= 1) {
            return;
        }
        int temp = 0;
        for (int num : array) {
            temp ^= num;
        }
        int index = findFirstOne(temp);
        for (int num : array) {
            if (isOne(num, index)) {
                // 从一组子数组中查找出现一次的数
                num1[0] ^= num;
            } else {
                // 从另外一组子数组中查找出现一次的数
                num2[0] ^= num;
            }
        }
    }

    /**
     * 查找数字中第几位为 1
     *
     * @param num 给定数字
     * @return 索引
     */
    private static int findFirstOne(int num) {
        int i = 0;
        while ((num & 1) == 0) {
            i++;
            num = num >> 1;
        }
        return i;
    }

    /**
     * 判断数字在二进制表示中从右起第 index 位是不是 1
     *
     * @param num   给定数字
     * @param index 索引位置
     * @return 若第 index 位是 1 返回true，否则返回 false
     */
    private boolean isOne(int num, int index) {
        return (((num >> index) & 1) == 1);
    }
}
