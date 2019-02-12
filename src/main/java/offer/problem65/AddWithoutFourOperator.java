package offer.problem65;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 65. 不用加减乘除做加法
 * @Date 2019-02-12
 * @Time 16:18
 */
public class AddWithoutFourOperator {
    public int soluiton(int num1,int num2) {
        int sum, carry;
        do {
            // 以 5(101) 和 17(10001) 相加为例
            // 进行异或操作：sum = 20(10100)；这一步不考虑进位
            sum = num1 ^ num2;
            // 进行位与运算，再左移一位：carry = 2(00010)；这一步考虑进位
            carry = (num1 & num2) << 1;
            //然后再继续相加
            num1 = sum;
            num2 = carry;
            //当不再存在进位时，则退出循环
        } while (num2 != 0);

        return sum;
    }
}
