package offer.problem44;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 44. 数字序列中某一位的数字
 * @Date 2019-01-31
 * @Time 14:46
 */
public class DigitAtIndex {
    public static int solution(int index) {
        /*
            1001 - 10 = 991
            991 - 90 * 2 = 811
            811 < 900 * 3

            811 / 3 = 270
            811 % 3 = 1

            即 270 的第 1 位，即 7
         */
        int digit = 2;
        if (index > 10) {
            index -= 10;
            double num;
            while (index > (num = digit * 9 * Math.pow(10, digit - 1))) {
                index -= num;
                digit++;
            }
            int number = index / digit;
            int i = digit - (index % digit);
            while (i > 1) {
                number /= 10;
                i--;
            }
            return number % 10;
        } else {
            return index;
        }
    }

    public static void main(String[] args) {
        // answer : 7
        System.out.println(solution(1001));
    }
}

