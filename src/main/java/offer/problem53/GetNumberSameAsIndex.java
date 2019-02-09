package offer.problem53;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 53.3. 数组中数值和下标相等的元素(二分查找)
 * @Date 2019-02-09
 * @Time 16:41
 */
public class GetNumberSameAsIndex {
    public static int solution(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (array[middle] > middle) {
                end = middle - 1;
            } else if (array[middle] < middle) {
                start = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,1,2,100,5000}));
    }
}
