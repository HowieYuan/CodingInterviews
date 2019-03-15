package leetcode.array.problem41;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 41. First Missing Positive (缺失的第一个正数)
 * @Date 2019-03-15
 * @Time 15:28
 */
public class FirstMissingPositive {
    /**
     * 遍历一次数组把大于等于 1 的和小于数组大小的值放到原数组对应位置，
     * 然后再遍历一次数组查当前下标是否和值对应，如果不对应那这个下标就是答案，
     * 否则遍历完都没出现那么答案就是数组长度加 1。
     */
    public int solution(int[] nums) {
        if (nums.length <= 0) {
            return 1;
        }
        int i = 0;
        while (i < nums.length) {
            int num = nums[i];
            if (num >= 1 && num <= nums.length && num != i + 1 && nums[num - 1] != num) {
                swap(nums, i, num - 1);
            } else {
                i++;
            }
        }
        for (int n = 0; n < nums.length; n++) {
            if (nums[n] != n + 1) {
                return n + 1;
            }
        }
        return nums.length + 1;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}