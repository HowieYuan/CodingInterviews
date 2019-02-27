package offer.problem11;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description p82   11. 旋转数组的最小数字
 * @Date 2018-11-26
 * @Time 18:01
 */
public class Eleven {
    /**
     * 针对递增数组
     */
    public int minNumberInRotateArray1(int[] array) {
        int middle, low = 0, high = array.length - 1;
        while (low < high) {
            middle = (high + low) / 2;
            if (array[middle] < array[low]) {
                high = middle;
            } else if (array[middle] > array[high]) {
                low = middle + 1;
            }
        }
        return array[high];
    }

    /**
     * 针对非递减数组
     */
    public int minNumberInRotateArray2(int[] array) {
        int middle, low = 0, high = array.length - 1;
        while (low < high) {
            middle = (high + low) / 2;
            if (array[middle] > array[high]) {
                low = middle + 1;
                //处理相等的情况
            } else if (array[middle] == array[high]) {
                high = high - 1;
            } else if (array[middle] < array[high]) {
                high = middle;
            }

        }
        return array[low];
    }


    /**
     * 非递减数组，方案3：
     *
     * @param number 数组
     * @return 数组中最小的数
     */
    private static int min(int[] number) {
        if (number == null || number.length <= 0) {
            throw new RuntimeException("");
        }

        // 第一个位置
        int index1 = 0;
        // 最后一个位置
        int index2 = number.length - 1;
        // 设置初始值
        int indexMin = 0;

        while (number[index1] >= number[index2]) {
            if (index2 - index1 == 1) {
                // 两个索引刚好相连
                indexMin = index2;
                break;
            }
            // 取中位数
            indexMin = (index1 + index2) / 2;

            // 如果 index1、index2、indexMin 三个索引指向数字
            if (number[index1] == number[index2] && number[index1] == number[indexMin]) {
                return minInorder(number, index1, index2);
            }
            if (number[index1] <= number[indexMin]) {
                index1 = indexMin;
            } else if (number[index2] >= number[indexMin]) {
                index2 = indexMin;
            }
        }
        return number[indexMin];
    }

    /**
     * 通过单层遍历找出给定数组中最小的数
     *
     * @param number 给定的数组
     * @param index1 搜索起始索引
     * @param index2 搜索结束索引
     * @return 数组中最小的数
     */
    private static int minInorder(int[] number, int index1, int index2) {
        int result = number[index1];
        for (int i = index1 + 1; i <= index2; i++) {
            if (result > number[i]) {
                result = number[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] array = {1,1,1,0,1,1};
        int[] array = {3, 4, 5, 6, 7, 1, 2};
        System.out.println(new Eleven().minNumberInRotateArray1(array));
    }
}
