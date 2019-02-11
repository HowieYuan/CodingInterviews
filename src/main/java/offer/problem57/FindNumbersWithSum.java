package offer.problem57;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 57.1. 和为 s 的两个数字
 * @Date 2019-02-10
 * @Time 23:21
 */
public class FindNumbersWithSum {
    /**
     * 方案1：如果数组是无序的，可以用 Set 辅助解决问题
     * 时间复杂度 O(n)
     */
    public ArrayList<Integer> solution1(int[] array, int sum) {
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : array) {
            if (set.contains(num)) {
                list.add(num);
                list.add(sum - num);
                return list;
            }
            int targetNum = sum - num;
            set.add(targetNum);
        }
        return list;
    }

    /**
     * 方案2：如果数组是有序的，可以直接从数组两头遍历，比对首尾数值，依次向中间靠拢
     * 还可以得到乘积最小的结果
     */
    public ArrayList<Integer> solution2(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        int ahead = array.length - 1;
        int behind = 0;
        while (behind < ahead) {
            if (array[behind] + array[ahead] > sum) {
                ahead--;
            } else if (array[behind] + array[ahead] < sum) {
                behind++;
            } else {
                list.add(array[behind]);
                list.add(array[ahead]);
                return list;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,4,7,11,15};
        System.out.println(new FindNumbersWithSum().solution2(array, 15));
    }
}
