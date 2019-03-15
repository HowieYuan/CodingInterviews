package leetcode.array.problem1;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 1. 两数之和
 *                  z 已知，在无序数组中找到两个数x和y，使x+y=z
 * @Date 2018-12-13
 * @Time 12:54
 */
public class TwoSum {
    /**
     * 利用map
     */
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int tt = target - nums[i];
            if (map.containsKey(nums[i])) {
                ans[0] = map.get(nums[i]);
                ans[1] = i;
                break;
            } else {
                map.put(tt, i);
            }
        }
        return ans;
    }

    /**
     * 暴力计算
     */
    public int[] twoSum(int[] nums, int target) {
        int[] a = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    a[0] = i;
                    a[1] = j;
                }
            }
        }
        return a;
    }
}
