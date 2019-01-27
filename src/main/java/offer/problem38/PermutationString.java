package offer.problem38;

import java.util.*;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 38. 字符串的排列（不允许有重复）
 * @Date 2019-01-27
 * @Time 16:55
 */
public class PermutationString {
    /**
     * TreeSet 保证不重复性和有序性
     */
    Set<String> set = new TreeSet<>();

    /**
     * 字符串的全排列，不允许有重复
     */
    public ArrayList<String> permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.length() <= 0) {
            return new ArrayList<>();
        }
        permutation(str.toCharArray(), 0);
        return new ArrayList<>(set);
    }

    /**
     * 典型的回溯法
     */
    private void permutation(char[] chars, int index) {
        if (index == chars.length - 1) {
            set.add(new String(chars));
            return;
        }
        //字符串分为两部分，第一部分为第一个字符，第二部分为后面的所有字符
        for (int i = index; i < chars.length; i++) {
            char temp = chars[i];
            chars[i] = chars[index];
            chars[index] = temp;

            permutation(chars, index + 1);

            temp = chars[i];
            chars[i] = chars[index];
            chars[index] = temp;
        }
    }

    public static void main(String[] args) {
        List list = new PermutationString().permutation("abc");
        System.out.println(list);
        list = new PermutationString().permutation("aab");
        System.out.println(list);
    }
}
