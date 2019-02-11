package offer.problem57;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 57.2. 和为 s 的连续正数序列
 * @Date 2019-02-11
 * @Time 16:00
 */
public class FindContinuousSequence {
    /**
     * 查找和为sum的连续正数序列
     *
     * @param sum 指定正数和
     * @return 查找结果
     */
    private static ArrayList<ArrayList<Integer>> solution(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (sum < 3) {
            return result;
        }
        int small = 1;
        int big = 2;
        int middle = (1 + sum) / 2;
        int curSum = small + big;

        while (small < middle) {
            if (sum == curSum) {
                ArrayList<Integer> list = getContinuousSequence(small, big);
                result.add(list);
            }
            if (curSum > sum) {
                curSum -= small;
                small++;
            } else {
                big++;
                curSum += big;
            }
        }

        return result;
    }

    /**
     * 将一串连续的数添加到List集合
     *
     * @param small 起始数
     * @param big   终止数
     * @return List集合
     */
    private static ArrayList<Integer> getContinuousSequence(int small, int big) {
        ArrayList<Integer> result = new ArrayList<>();
        if (small <= big) {
            for (int i = small; i <= big; i++) {
                result.add(i);
            }
        }
        return result;
    }
}
