package offer.problem46;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 46. 把数字翻译成字符串
 * @Date 2019-01-31
 * @Time 16:54
 */
public class GetTranslationCount {
    public static int solution(int number) {
        if (number < 0) {
            return 0;
        }
        if (number == 1) {
            return 1;
        }
        return getTranslationCount(Integer.toString(number));
    }

    /**
     * 动态规划，从右到左计算。
     * f(r-2) = f(r-1) + g(r-2,r-1) * f(r);
     * 如果r-2，r-1能够翻译成字符，则g(r-2,r-1)=1，否则为0
     */
    private static int getTranslationCount(String number) {
        int f1 = 0, f2 = 1, g;
        int temp;
        for (int i = number.length() - 2; i >= 0; i--) {
            if (Integer.parseInt(number.charAt(i) + "" + number.charAt(i + 1)) < 26) {
                g = 1;
            } else {
                g = 0;
            }
            temp = f2;
            f2 = f2 + g * f1;
            f1 = temp;
        }
        return f2;
    }

    public static void main(String[] args) {
        System.out.println(solution(-10));  //0
        System.out.println(solution(1234));  //3
        System.out.println(solution(12258)); //5
    }
}