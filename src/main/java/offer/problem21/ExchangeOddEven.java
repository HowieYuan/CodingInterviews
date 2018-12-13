package offer.problem21;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 21. 调整数组顺序使奇数位于偶数前面
 * @Date 2018-12-12
 * @Time 16:35
 */
public class ExchangeOddEven {

    public static int[] exchange1(int[] nums) {
        int oddIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                int temp = nums[i];
                nums[i] = nums[oddIndex];
                nums[oddIndex] = temp;
                oddIndex++;
            }
        }
        return nums;
    }

    public static int[] exchange2(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            while (low < high && nums[low] % 2 != 1) {
                low++;
            }
            while (low < high && nums[high] % 2 != 0) {
                high--;
            }
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(exchange2(new int[]{1, 2, 8, 9, 7, 5, 3, 1, 2, 4, 6, 8})));
    }
}
