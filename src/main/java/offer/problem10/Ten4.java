package offer.problem10;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description p79 矩形覆盖
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * @Date 2018-11-26
 * @Time 12:37
 */
public class Ten4 {
    /**
     * 迭代
     */
    public int rectCover(int target) {
        if(target == 0) {
            return 0;
        }
        if(target == 1) {
            return 1;
        }
        if(target == 2) {
            return 2;
        }
        int num = 2, result = 2, pre = 1;
        while(num++ != target) {
            result += pre;
            pre = result - pre;
        }
        return result;
    }


    /**
     * 递归
     */
    public int rectcover2(int target) {
        if(target == 0) {
            return 0;
        }
        if(target == 1) {
            return 1;
        }
        if(target == 2) {
            return 2;
        }
        return rectcover2(target - 1) + rectcover2(target - 2);
    }
}
