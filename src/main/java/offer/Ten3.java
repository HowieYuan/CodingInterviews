package offer;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description p78 青蛙变态跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @Date 2018-11-21
 * @Time 16:04
 */
public class Ten3 {
    /**
     *          | 1       ,(n=0 )
     *
     * f(n) =   | 1       ,(n=1 )
     *
     *          | 2*f(n-1),(n>=2)
     *
     * f(n) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2) + f(n-1) = f(n-1) + f(n-1)
     */
    public int JumpFloor(int target) {
        if (target <= 0) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else {
            return 2 * JumpFloor(target - 1);
        }
    }
}
