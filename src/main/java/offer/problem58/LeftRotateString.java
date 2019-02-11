package offer.problem58;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 58.2. 左旋转字符串
 * @Date 2019-02-11
 * @Time 21:06
 */
public class LeftRotateString {
    /**
     * 例：abcdefg 左旋转两位
     * 先分别旋转前后半部分，bacdefg，bagfedc
     * 然后全部旋转 cdefgab
     */
    public String solution(String str, int n) {
        if (n <= 0) {
            return str;
        }
        char[] c = str.toCharArray();
        reverse(c, 0, n - 1);
        reverse(c, n, c.length - 1);
        reverse(c, 0, c.length - 1);
        return new String(c);
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

    public static void main(String[] args) {
        String s = new LeftRotateString().solution("abcdefg", 2);
        System.out.println(s);
    }
}
