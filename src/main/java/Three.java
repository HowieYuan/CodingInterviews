import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 数组中重复的数字
 * @Date 2018-09-20
 * @Time 20:22
 */
public class Three {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 2, 3, 4};
        System.out.println(findNumber4(a));
    }

    /**
     * 不改变数组
     * 使用辅助空间
     * O(n)
     */
    private static List<Integer> findNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] statistics = new int[nums.length];
        for (int i : nums) {
            statistics[i]++;
        }
        int num = 0;
        for (int i : statistics) {
            if (i > 1) {
                list.add(num);
            }
            num++;
        }
        return list;
    }

    /**
     * 不改变数组
     * 使用辅助空间
     * O(n)
     */
    private static List<Integer> findNumber2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<Integer> statistics = new ArrayList<>();
        for (int i : nums) {
            if (statistics.contains(i)) {
                list.add(i);
            } else {
                statistics.add(i);
            }
        }
        return list;
    }

    /**
     * 改变数组
     * 不使用辅助空间
     * O(n)
     */
    private static List<Integer> findNumber3(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                list.add(nums[i]);
            }
        }
        return list;
    }

    /**
     * 改变数组
     * 不使用辅助空间
     * O(n)
     */
    private static List<Integer> findNumber4(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i]) {
                if (nums[nums[i]] == nums[i]) {
                    if (!list.contains(nums[i])) {
                        list.add(nums[i]);
                    }
                    break;
                }
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
            }
        }
        return list;
    }

    /**
     * 只取任意一个重复数字
     * 不改变数组
     * 不使用辅助空间
     * O(nlogn)
     */
    private static int findNumbe5(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (end >= start) {
            int middle = (end - start) / 2 + 1;
            int count = count(nums, start, middle);
            if (end == start) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            if (count > middle - start + 1) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    private static int count(int[] nums, int start, int end) {
        int count = 0;
        for (int i : nums) {
            if (i >= start && i <= end) {
                count++;
            }
        }
        return count;
    }
}
