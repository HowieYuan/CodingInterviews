package offer.problem58;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 58.1. 翻转单词顺序
 * @Date 2019-02-11
 * @Time 16:24
 */
public class ReverseSentence {
    /**
     * 对一个字符串数组中的单词进行翻转
     *
     * @param str 字符串
     * @return 翻转后的字符串数组
     */
    private static String solution(String str) {
        char[] data = str.toCharArray();
        if (data.length < 1) {
            return str;
        }
        // 翻转第一次
        reverse(data, 0, data.length - 1);
        int start = 0, end = 0;
        while (start < data.length) {
            if (data[start] == ' ') {
                // 当头索引是空格时需要继续前移，到达真正的单词头索引
                start++;
                end++;
            } else if (end == data.length || data[end] == ' ') {
                // 找到一个单词进行翻转
                // 注意这里-1操作，不需要翻转空格
                reverse(data, start, end - 1);
                // 继续移动尾索引并重新设置头索引
                end++;
                start = end;
            } else {
                // 继续移动尾索引
                end++;
            }
        }
        return new String(data);
    }

    /**
     * 对字符串数组进行翻转
     *
     * @param data  字符串数组
     * @param start 翻转起始索引
     * @param end   翻转终止索引
     */
    private static void reverse(char[] data, int start, int end) {
        if (data == null || data.length < 1 || start < 0 || end > data.length || start > end) {
            return;
        }
        while (start < end) {
            char temp = data[start];
            data[start] = data[end];
            data[end] = temp;

            start++;
            end--;
        }
    }
}
