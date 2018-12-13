package leetcode.collection.problem15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 15. 3Sum  三数之和
 * @Date 2018-12-14
 * @Time 1:21
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int num = 0 - nums[i], low = i + 1, high = nums.length - 1;
                while (low < high) {
                    if (nums[low] + nums[high] == num) {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] > num) {
                        high--;
                    } else if (nums[low] + nums[high] < num) {
                        low++;
                    }
                }
            }
        }
        return result;
    }
}
