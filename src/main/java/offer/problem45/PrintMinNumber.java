package offer.problem45;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 45. 把数组排成最小的数
 * @Date 2019-01-31
 * @Time 16:54
 */
public class PrintMinNumber {
    public String solution(int[] numbers) {
        if (numbers.length <= 0) {
            return null;
        }
        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }

        // 比较器比较两个字符串先后顺序
        partition(nums, 0, numbers.length - 1,
                (String s1, String s2) -> (s1 + s2).compareTo(s2 + s1));

        StringBuilder stringBuilder = new StringBuilder();
        for (String num : nums) {
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }

    private void partition(String[] nums, int start, int end, Comparator<String> comparator) {
        if (start > end) {
            return;
        }
        int left = start;
        int right = end;
        String middle = nums[start];
        while (start < end) {
            while (start < end && comparator.compare(middle, nums[end]) < 0){
                end--;
            }
            if (start < end) {
                nums[start] = nums[end];
                start++;
            }
            while (start < end && comparator.compare(middle, nums[start]) > 0){
                start++;
            }
            if (start < end) {
                nums[end] = nums[start];
                end--;
            }
        }
        nums[start] = middle;
        partition(nums, left, start - 1, comparator);
        partition(nums, start + 1, right, comparator);
    }
}
