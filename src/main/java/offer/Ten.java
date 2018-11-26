package offer;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description p74  10.斐波那契
 * @Date 2018-11-19
 * @Time 16:15
 */
public class Ten {
    /**
     * 迭代（推荐）
     */
    public int fibonacci1(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        int result = 1, last = 0, num = 2;
        while(num++ <= n) {
            result = result + last;
            last = result - last;
        }
        return result;
    }

    /**
     * 递归
     */
    public int fibonacci2(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        return fibonacci2(n - 1) + fibonacci2(n - 2);
    }
}
