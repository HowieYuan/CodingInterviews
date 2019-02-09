package offer.problem53;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 53.2 0~n-1 中缺失的数字(二分查找)
 * @Date 2019-02-09
 * @Time 16:02
 */
public class GetMissingNumber {
    public int solution(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (array[middle] == middle) {
                start = middle + 1;
            } else {
                if (middle == start || array[middle - 1] == middle - 1) {
                    return middle;
                }
                end = middle - 1;
            }
        }
        return -1;
    }
}
