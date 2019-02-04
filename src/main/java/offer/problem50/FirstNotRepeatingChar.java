package offer.problem50;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 50.1. 第一个只出现一次的字符
 * @Date 2019-02-04
 * @Time 17:07
 */
public class FirstNotRepeatingChar {
    /**
     * 数组存储
     */
    public int solution1(String str) {
        if (str.length() <= 0) {
            return -1;
        }
        char[] chars = str.toCharArray();
        int[] times = new int[58];
        for (char c : chars) {
            times[c - 65]++;
        }
        for (char c : chars) {
            if (times[c - 65] == 1) {
                return str.indexOf(c);
            }
        }
        return -1;
    }

    /**
     * HashMap 存储
     */
    private static char solution2(String s) {
        if (s == null || s.length() < 1) {
            throw new RuntimeException("非法输入!!!");
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] strChar = s.toCharArray();
        // 计数
        for (int i = 0; i < strChar.length; i++) {
            char ch = strChar[i];
            if (map.containsKey(ch)) {
                // 如果出现超过一次，设置为-2
                map.put(ch, -2);
            } else {
                // 如果第一次出现，则记录其索引位置
                map.put(ch, i);
            }
        }
        char result = '\0';
        int index = Integer.MAX_VALUE;

        for (char key : map.keySet()) {
            // 找到值为非零且最小的map
            if (map.get(key) >= 0 && map.get(key) < index) {
                index = map.get(key);
                result = key;
            }
        }
        return result;
    }
}