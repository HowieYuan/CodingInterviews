package offer;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description p77 青蛙跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * @Date 2018-11-21
 * @Time 15:57
 */
public class Ten2 {
    /**
     * 迭代
     */
    public int jumpFloor2(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int pre = 1, result = 2, n = 2;
        while (target != n++) {
            result = pre + result;
            pre = result - pre;
        }
        return result;
    }

    /**
     * 递归
     */
    public int jumpFloor(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }
}
