package offer;

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
        while (low <= high) {
            if (high - low == 1) {
                return array[high];
            }
            middle = (high + low) / 2;
            if (array[middle] < array[low]) {
                high = middle;
            } else if (array[middle] > array[high]) {
                low = middle;
            }
        }
        return -1;
    }

    /**
     * 针对非递减数组
     */
    public int minNumberInRotateArray2(int [] array) {
        int middle, low = 0, high = array.length - 1;
        while(low < high) {
            middle = (high + low) / 2;
            if(array[middle] > array[high]) {
                low = middle + 1;
                //处理相等的情况
            } else if(array[middle] == array[high]){
                high = high - 1;
            } else if(array[middle] < array[high]){
                high = middle;
            }

        }
        return array[low];
    }

    public static void main(String[] args) {
        int[] array = {1,1,1,0,1,1};
        System.out.println(new Eleven().minNumberInRotateArray1(array));
    }
}
