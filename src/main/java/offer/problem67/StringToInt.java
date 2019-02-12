package offer.problem67;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 67. 把字符串转换成整数
 * @Date 2019-02-12
 * @Time 17:51
 */
public class StringToInt {
    /**
     * 将给定是字符串转换为整数
     *
     * @param num 给定字符串
     * @return 转换后的整数结果
     */
    private static int stringToInt(String num) {
        if (num == null || num.length() < 1) {
            throw new RuntimeException("非法输入！！！");
        }

        char minus = '-';
        char plus = '+';
        char minNum = '0', maxNum = '9';
        char first = num.charAt(0);
        if (first == minus) {
            // 带符号负数
            return strToIntCore(num, 1, true);
        } else if (first == plus) {
            // 带符号正数
            return strToIntCore(num, 1, false);
        } else if (first <= maxNum && first >= minNum) {
            // 不带符号正数
            return strToIntCore(num, 0, false);
        } else {
            throw new RuntimeException("非法输入！！！");
        }
    }

    /**
     * 将不带符号的字符串转化为整数
     *
     * @param num   字符串
     * @param index 转换起始索引
     * @param minus 是否是负数
     * @return 转换后的整数结果
     */
    private static int strToIntCore(String num, int index, boolean minus) {
        if (index >= num.length()) {
            throw new NumberFormatException(num);
        }

        int result;
        long temp = 0;
        while (index < num.length()) {
            if (!isDigit(num.charAt(index))) {
                throw new NumberFormatException(num);
            }
            temp = temp * 10 + (num.charAt(index) - '0');
            index++;
            if (temp > 0x8000_0000L) {
                throw new NumberFormatException(num);
            }
        }

        if (minus) {
            result = (int) -temp;
        } else {
            result = (int) temp;
        }
        return result;
    }

    /**
     * 判断一个字符是否在 '0'-'9' 之间
     *
     * @param ch 给定字符
     * @return 返回判断结果
     */
    private static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static void main(String[] args) {
        System.out.println(stringToInt("12a3"));
        System.out.println(stringToInt("+123"));
        System.out.println(stringToInt("-123"));
        try {
            System.out.println(stringToInt("."));
        } catch (Exception e) {
            e.getMessage();
            System.out.println("输入格式错误！");
        }
        try {
            System.out.println(stringToInt("1111111111111111111111111111111111111111111111111111111111"));
        } catch (Exception e) {
            e.getMessage();
            System.out.println("字符串过长");
        }
    }
}
