import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description
 * @Date 2018-09-26
 * @Time 16:45
 */
public class Five {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("We are happy.");
        System.out.println(replaceSpace(s));
    }

    private static String replaceSpace(StringBuilder stringBuilder) {
        int length = stringBuilder.length();
        char[] chars = stringBuilder.toString().toCharArray();
        char[] c = new char[50];
        int i = 0;
        for (char cc : chars) {
            c[i++] = cc;
        }
        int space = 0;
        for (char ccc : c) {
            if (ccc == ' ') {
                space++;
            }
        }
        int currentLength = length + space * 2;
        int nowLength = currentLength;

        while (length >= 0) {
            if (c[length--] != ' ') {
                c[currentLength--] = c[length + 1];
            } else {
                c[currentLength--] = '0';
                c[currentLength--] = '2';
                c[currentLength--] = '%';
            }
        }
        return new String(c, 0, nowLength);
    }
}
