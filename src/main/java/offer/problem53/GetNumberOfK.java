package offer.problem53;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 53.1. 数字在排序数组中出现的次数(二分查找)
 * @Date 2019-02-09
 * @Time 15:07
 */
public class GetNumberOfK {
    /**
     * 利用二分查找找到第一个出现和最后出现的位置
     */
    private int solution(int[] array, int k) {
        if (array.length <= 0) {
            return 0;
        }
        int first = getFirstNumIndex(array, k);
        int last = getLastNumIndex(array, k);
        if (first == -1) {
            return 0;
        }
        return last - first + 1;
    }

    private int getLastNumIndex(int[] array, int num) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (num > array[middle]) {
                start = middle + 1;
            } else if (num < array[middle]) {
                end = middle - 1;
            } else {
                if (middle == end || array[middle + 1] != num) {
                    return middle;
                }
                start = middle + 1;
            }
        }
        return -1;
    }


    private int getFirstNumIndex(int[] array, int num) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (num > array[middle]) {
                start = middle + 1;
            } else if (num < array[middle]) {
                end = middle - 1;
            } else {
                if (middle == start || array[middle - 1] != num) {
                    return middle;
                }
                end = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 3, 3, 3, 4, 5};
        System.out.println(new GetNumberOfK().getLastNumIndex(a, 2));
        System.out.println(new GetNumberOfK().getFirstNumIndex(a, 2));
    }

}
