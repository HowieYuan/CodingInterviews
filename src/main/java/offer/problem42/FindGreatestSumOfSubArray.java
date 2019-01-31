package offer.problem42;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 42. 连续子数组的最大和
 * @Date 2019-01-31
 * @Time 11:45
 */
public class FindGreatestSumOfSubArray {

    public int solution1(int[] array) {
        if (array.length <= 0) {
            return 0;
        }
        //当前累加最大值
        int currentSum = array[0];
        //全局累加最大值
        int maxSum = currentSum;
        for (int i = 1; i < array.length; i++) {
            int num = array[i];
            //如果当前累加是负数，则把之前累加的都剔除
            //否则继续累加
            if (currentSum < 0) {
                currentSum = num;
            } else {
                currentSum += num;
            }
            //如果当前累加的最大值大于全局最大值，则替换
            maxSum = currentSum > maxSum ? currentSum : maxSum;
        }
        return maxSum;
    }
}
