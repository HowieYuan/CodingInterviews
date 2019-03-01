package leetcode.array.problem88;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 88. 合并两个有序数组
 *                  假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素
 * @Date 2019-02-28
 * @Time 15:48
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[index--] = nums1[m--];
            } else {
                nums1[index--] = nums2[n--];
            }
        }
        //因为是在 nums1 数组上进行处理，所以如果 n 在结束上面的循环后已经小于 0，则合并已经完成
        while (n >= 0) {
            nums1[index--] = nums2[n--];
        }
    }
}
