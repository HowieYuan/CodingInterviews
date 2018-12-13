package leetcode.collection.problem242;

import java.util.*;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 242. Valid Anagram  有效的字母异位词
 * @Date 2018-12-13
 * @Time 1:59
 */
public class ValidAnagram {
    /**
     * Map 实现
     */
    public static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (sMap.containsKey(sc)) {
                sMap.put(sc, sMap.get(sc) + 1);
            } else {
                sMap.put(sc, 1);
            }
            if (tMap.containsKey(tc)) {
                tMap.put(tc, tMap.get(tc) + 1);
            } else {
                tMap.put(tc, 1);
            }
        }
        return sMap.equals(tMap);
    }

    /**
     * 数组实现1
     */
    public static boolean isAnagram2(String s, String t) {
        int[] freq = new int[26];
        if (s.length() != t.length()) {
            return false;
        }
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            freq[t.charAt(i) - 'a']--;
            if (freq[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 数组实现2
     */
    public static boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] bucket = new int[128];
        for (char c : s.toCharArray()) {
            bucket[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            bucket[c - 'a']--;
        }
        for (int n : bucket) {
            if (n > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 排序实现
     */
    public static boolean isAnagram4(String s, String t) {
        char[] ca1 = s.toCharArray();
        char[] ca2 = t.toCharArray();
        Arrays.sort(ca1);
        Arrays.sort(ca2);
        return Arrays.equals(ca1, ca2);
    }



    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        List list2 = new ArrayList();
        list2.add(3);
        list2.add(2);
        list2.add(1);
        System.out.println(list1.equals(list2));
        Arrays.asList(1, 1, 1);
    }
}
