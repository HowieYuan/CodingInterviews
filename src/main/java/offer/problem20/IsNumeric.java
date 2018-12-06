package offer.problem20;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description p127  20. 表示数值的字符串
 * @Date 2018-12-06
 * @Time 17:59
 */
public class IsNumeric {
    public boolean isNumeric(char[] str) {
        // 标记符号、小数点、e是否出现过
        boolean sign = false, decimal = false, hasE = false;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'e' || str[i] == 'E') {
                // e后面一定要接数字
                if (i == str.length - 1) {
                    return false;
                }
                // 不能同时存在两个e
                if (hasE) {
                    return false;
                }
                hasE = true;
            } else if (str[i] == '+' || str[i] == '-') {
                // 第二次出现+-符号，则必须紧接在e之后
                if (sign && str[i - 1] != 'e' && str[i - 1] != 'E') {
                    return false;
                }
                // 第一次出现+-符号，且不是在字符串开头，则也必须紧接在e之后
                if (!sign && i > 0 && str[i - 1] != 'e' && str[i - 1] != 'E') {
                    return false;
                }
                sign = true;
            } else if (str[i] == '.') {
                // e后面不能接小数点，小数点不能出现两次
                if (hasE || decimal) {
                    return false;
                }
                decimal = true;
                // 不合法字符
            } else if (str[i] < '0' || str[i] > '9') {
                return false;
            }
        }
        return true;
    }
}
