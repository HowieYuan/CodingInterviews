package offer.problem16;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description p110   16. 数值的整数次方
 * @Date 2018-11-29
 * @Time 14:21
 */
public class Power {
    /**
     * 常规方法
     *
     * @param base     底数
     * @param exponent 指数
     */
    public static double power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        int absEx = Math.abs(exponent);
        double num = base;
        while (absEx > 1) {
            base *= num;
            absEx--;
        }
        //考虑指数为负
        return exponent < 0 ? 1 / base : base;
    }

    /**
     * 快速幂
     */
    public double power2(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        int absEx = Math.abs(exponent);
        double result = 1;
        while (absEx != 0) {
            if ((absEx & 1) == 1) {
                result *= base;
            }
            base *= base;
            absEx >>= 1;
        }
        return exponent < 0 ? 1 / result : result;
    }

    public static void main(String[] args) {
        System.out.println(power(2, -3));
        System.out.println(power(0, 5));
        System.out.println(power(100, 0));
        System.out.println(power(0, -3));

        System.out.println(Math.pow(0, 0));
    }
}
