package offer.problem39;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 39. 数组中出现次数超过一半的数字
 * @Date 2019-01-27
 * @Time 18:02
 */
public class MoreThanHalfNum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(new MoreThanHalfNum().solution1(nums));
    }

    /**
     * 快排划分思想法(如果是出现超过一半的数字，那么必定出现在顺序的中央)
     */
    public int solution1(int[] array) {
        if (array.length <= 0) {
            return 0;
        } else if (array.length == 1) {
            return array[0];
        }

        int middleIndex = partition(array, 0, array.length - 1);
        int count = 0;
        for (int num : array) {
            if (num == array[middleIndex]) {
                count++;
            }
        }
        if (count > array.length / 2) {
            return array[middleIndex];
        }
        return 0;
    }

    /**
     * 划分函数
     */
    private static int partition(int[] array, int start, int end) {
        int temp = array[start];
        while (start < end) {
            while (array[end] >= temp && start < end) {
                end--;
            }
            // 从数组结尾开始找到第一个比temp小的索引
            if (start < end) {
                // 交换位置
                array[start] = array[end];
                // 记住这里end的位置是空的
                start++;
            }
            /* 切换扫描指针 */
            while (array[start] < temp && start < end) {
                start++;
            }
            // 从数组开头开始找到第一个比temp大的索引
            if (start < end) {
                array[end] = array[start];
                // 这里start的位置是空的
                end--;
            }
        }
        // start == end
        array[start] = temp;
        return start;
    }


    /**
     * 摩尔投票算法
     * <p>
     * 找出一组数字序列中出现次数大于总数1/2的数字（并且假设这个数字一定存在）。
     * 显然这个数字只可能有一个。
     * <p>
     * 摩尔投票算法是基于这个事实：每次从序列里选择两个不相同的数字删除掉（或称为“抵消”），
     * 最后剩下一个数字或几个相同的数字，不一定是出现次数大于总数一半的那个。
     * 但是抵消掉的，肯定不是结果
     */
    public int solution2(int[] array) {
        if (array.length <= 0) {
            return 0;
        } else if (array.length == 1) {
            return array[0];
        }
        int count = 0;
        int currentNum = 0;
        for (int num : array) {
            if (count == 0) {
                currentNum = num;
                count++;
            } else if (currentNum == num) {
                count++;
            } else {
                count--;
            }
        }
        if (count == 0) {
            return 0;
        } else {
            count = 0;
            for (int num : array) {
                if (num == currentNum) {
                    count++;
                }
            }
            if (count > array.length / 2) {
                return currentNum;
            }
            return 0;
        }
    }

    /**
     * 利用 HashMap 计算次数
     */
    public int solution3(int[] array) {
        if (array.length <= 0) {
            return 0;
        } else if (array.length == 1) {
            return array[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int half = array.length / 2;
        for (int num : array) {
            Integer times = map.get(num);
            if (times == null) {
                map.put(num, 1);
            } else if (++times > half) {
                return num;
            } else {
                map.put(num, times);
            }
        }
        return 0;
    }


    /*
        还有一种方法：直接排序，然后取位于中间的数，判断出现次数
     */
}
