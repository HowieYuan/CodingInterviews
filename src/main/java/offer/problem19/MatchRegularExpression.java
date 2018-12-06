package offer.problem19;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description p124  19. 正则表达式匹配
 * @Date 2018-12-06
 * @Time 17:27
 */
public class MatchRegularExpression {
    private static final char STAR = '*';
    private static final char POINT = '.';

    /**
     * 递归方式
     *
     * @param str     主字符数组
     * @param pattern 匹配字符数组
     */
    public boolean match(char[] str, char[] pattern) {
        //如 "", ""
        if (str.length <= 0 && pattern.length <= 0) {
            return true;
        }
        return matchCore(str, pattern, 0, 0);
    }


    /**
     * 核心匹配方法
     *
     * @param str     主字符数组
     * @param pattern 匹配字符数组
     * @param s       主字符数组当前匹配位置
     * @param p       匹配字符数组当前匹配位置
     */
    public boolean matchCore(char[] str, char[] pattern, int s, int p) {
        //若输入字符串、匹配字符串遍历同时到达结束，表示匹配成功
        if (p >= pattern.length && s >= str.length) {
            return true;
        }
        //若只有匹配字符串遍历结束，表示匹配失败
        if (p >= pattern.length && s < str.length) {
            return false;
        }
        //匹配字符串遍历未结束，即使主字符数组已遍历完，也不能确定输入字符串的情况（因为 b* 可以代表空）
        if (p + 1 < pattern.length && pattern[p + 1] == STAR) {
            //主字符数组已遍历完，检查是否为 b* 情况，因此 p + 2
            if (s >= str.length) {
                return matchCore(str, pattern, s, p + 2);
            } else if (str[s] == pattern[p] || pattern[p] == POINT) {
                return matchCore(str, pattern, s, p + 2) ||
                        matchCore(str, pattern, s + 1, p + 2) ||
                        matchCore(str, pattern, s + 1, p);
            } else {
                return matchCore(str, pattern, s, p + 2);
            }
        }
        //pattern[p + 1] 不为 * 符号的情况
        if (s >= str.length) {
            return false;
        } else if (str[s] == pattern[p] || pattern[p] == POINT) {
            return matchCore(str, pattern, s + 1, p + 1);
        }
        return false;
    }
}
