package offer.problem64;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 64. 求 1+2+3+...+n
 * @Date 2019-02-12
 * @Time 16:12
 */
public class Accumulate {
    public static int solution(int n) {
        int temp = n;
        //当 temp<=0 时，式子后半部分则不会执行，达到中断递归的目的
        boolean result = (temp > 0) && ((temp += solution(n - 1)) > 0);
        return temp;
    }
}
